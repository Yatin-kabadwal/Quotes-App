package com.example.quotes

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudyActivity : AppCompatActivity() {

    private val studyQuotes = listOf(
        "The beautiful thing about learning is that no one can take it away from you. - B.B. King",
        "The more that you read, the more things you will know. The more that you learn, the more places you’ll go. - Dr. Seuss",
        "Education is the most powerful weapon which you can use to change the world. - Nelson Mandela",
        "Live as if you were to die tomorrow. Learn as if you were to live forever. - Mahatma Gandhi",
        "The expert in anything was once a beginner. - Helen Hayes"
    )

    private var currentIndex = 0

    private lateinit var quoteText: TextView
    private lateinit var quoteAuthor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)

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
        val quoteParts = studyQuotes[currentIndex].split(" - ")
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
        if (currentIndex < studyQuotes.size - 1) {
            currentIndex++
            showQuote()
        }
    }

    private fun shareQuote() {
        val currentQuote = studyQuotes[currentIndex]
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, currentQuote)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
}
