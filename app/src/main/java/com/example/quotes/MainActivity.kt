package com.example.quotes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lifecard = findViewById<CardView>(R.id.life)
        val lovecard = findViewById<CardView>(R.id.love)
        val studycard = findViewById<CardView>(R.id.study)
        val motivationalcard = findViewById<CardView>(R.id.motivational)
        val personalcard = findViewById<CardView>(R.id.personal)
        val famouscard = findViewById<CardView>(R.id.famous)


        lovecard.setOnClickListener {
            intent = Intent(this,Love::class.java)
            startActivity(intent)
        }


    }
}