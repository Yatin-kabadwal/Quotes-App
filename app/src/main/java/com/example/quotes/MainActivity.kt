package com.example.quotes

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var exitDialog: AlertDialog

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

        exitDialog = AlertDialog.Builder(this)
            .setTitle("Exit Confirmation")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Exit") { dialog, which ->
                finish()
            }
            .setNegativeButton("Cancel", null)
            .create()

        lovecard.setOnClickListener {
            intent = Intent(this, Love::class.java)
            startActivity(intent)
        }

        lifecard.setOnClickListener {
            intent = Intent(this, LifeActivity::class.java)
            startActivity(intent)
        }

        studycard.setOnClickListener {
            intent = Intent(this, StudyActivity::class.java)
            startActivity(intent)
        }

        motivationalcard.setOnClickListener {
            intent = Intent(this,MotivationalActivity::class.java)
            startActivity(intent)
        }

        personalcard.setOnClickListener {
            intent = Intent(this,PersonalActivity::class.java)
            startActivity(intent)
        }

        famouscard.setOnClickListener {
            intent = Intent(this,FamousActivity::class.java)
            startActivity(intent)
        }
    }













    override fun onBackPressed() {
        // Show exit confirmation dialog
        exitDialog.show()
    }
}
