package com.example.quotes
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FamousActivity : AppCompatActivity() {

    private val famousQuotes = listOf(
        "One day or day one you decide. - Kaka",
        "The only thing we have to fear is fear itself. - Franklin D. Roosevelt",
        "I think, therefore I am. - René Descartes",
        "That's one small step for man, one giant leap for mankind. - Neil Armstrong",
        "In the end, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King Jr.",
        "The journey of a thousand miles begins with one step. - Lao Tzu"
    )

    private var currentIndex = 0

    private lateinit var quoteText: TextView
    private lateinit var quoteAuthor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_famous)


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
        val quoteParts = famousQuotes[currentIndex].split(" - ")
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
        if (currentIndex < famousQuotes.size - 1) {
            currentIndex++
            showQuote()
        }
    }

    private fun shareQuote() {
        val currentQuote = famousQuotes[currentIndex]
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, currentQuote)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
}
