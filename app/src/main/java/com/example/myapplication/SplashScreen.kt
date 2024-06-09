package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val exitBtn = findViewById<Button>(R.id.exitBtn)
        val startBtn = findViewById<Button>(R.id.startBtn)

        exitBtn.setOnClickListener {
            finish()
        }
        startBtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}


