package com.example.quotes

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PersonalActivity : AppCompatActivity() {

    private val personalQuotes = listOf(
        "I can 100 times is more important than IQ. - Kaka",
        "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment. - Ralph Waldo Emerson",
        "Do not go where the path may lead, go instead where there is no path and leave a trail. - Ralph Waldo Emerson",
        "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela",
        "You have within you right now, everything you need to deal with whatever the world can throw at you. - Brian Tracy",
        "What lies behind us and what lies before us are tiny matters compared to what lies within us. - Ralph Waldo Emerson"
    )

    private var currentIndex = 0

    private lateinit var quoteText: TextView
    private lateinit var quoteAuthor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        quoteText = findViewById(R.id.quoteText)
        quoteAuthor = findViewById(R.id.quoteAuthor)

        findViewById<TextView>(R.id.previousButton).setOnClickListener {
            showPreviousQuote()
        }

        findViewById<TextView>(R.id.nextButton).setOnClickListener {
            showNextQuote()
        }

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            shareQuote()
        }

        showQuote()
    }

    private fun showQuote() {
        val quoteParts = personalQuotes[currentIndex].split(" - ")
        quoteText.text = quoteParts[0]
        quoteAuthor.text = quoteParts[1]
    }

    private fun showPreviousQuote() {
        if (currentIndex > 0) {
            currentIndex--
            showQuote()
        }
    }

    private fun showNextQuote() {
        if (currentIndex < personalQuotes.size - 1) {
            currentIndex++
            showQuote()
        }
    }

    private fun shareQuote() {
        val currentQuote = personalQuotes[currentIndex]
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, currentQuote)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
}
