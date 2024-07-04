package com.example.quotes
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Love : AppCompatActivity() {
    private val loveQuotes = listOf(
        "Love is composed of a single soul inhabiting two bodies. - Aristotle",
        "Being deeply loved by someone gives you strength, while loving someone deeply gives you courage. - Lao Tzu",
        "We are shaped and fashioned by what we love. - Johann Wolfgang von Goethe",
        "Love is when the other person's happiness is more important than your own. - H. Jackson Brown, Jr.",
        "To love and be loved is to feel the sun from both sides. - David Viscott"
    )

    private var currentIndex = 0

    private lateinit var quoteText: TextView
    private lateinit var quoteAuthor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love)

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
        val quoteParts = loveQuotes[currentIndex].split(" - ")
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
        if (currentIndex < loveQuotes.size - 1) {
            currentIndex++
            showQuote()
        }
    }

    private fun shareQuote() {
        val currentQuote = loveQuotes[currentIndex]
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, currentQuote)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
}
