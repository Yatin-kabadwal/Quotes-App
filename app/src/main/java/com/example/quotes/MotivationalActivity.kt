package com.example.quotes

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MotivationalActivity : AppCompatActivity() {

    private val motivationalQuotes = listOf(
        "The only way to do great work is to love what you do. - Steve Jobs",
        "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
        "Don't watch the clock; do what it does. Keep going. - Sam Levenson",
        "Believe you can and you're halfway there. - Theodore Roosevelt",
        "Act as if what you do makes a difference. It does. - William James"
    )

    private var currentIndex = 0

    private lateinit var quoteText: TextView
    private lateinit var quoteAuthor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivational)
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
        val quoteParts = motivationalQuotes[currentIndex].split(" - ")
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
        if (currentIndex < motivationalQuotes.size - 1) {
            currentIndex++
            showQuote()
        }
    }

    private fun shareQuote() {
        val currentQuote = motivationalQuotes[currentIndex]
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, currentQuote)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
}
