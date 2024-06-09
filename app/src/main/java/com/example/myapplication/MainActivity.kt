package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val screenTimeData = mutableListOf<Int>()
        val screenTimeEditText = findViewById<EditText>(R.id.editText)
        val addButton = findViewById<Button>(R.id.addBtn)
        val clearButton = findViewById<Button>(R.id.clearBtn)
        val btnView = findViewById<Button>(R.id.btnView)

        fun addScreenTime() {
            val screenTimeString = screenTimeEditText.text.toString()
            if (screenTimeString.isNotEmpty()) {
                try {
                    val screenTime = screenTimeString.toInt()
                    if (screenTime >= 0) {
                        screenTimeData.add(screenTime)
                        screenTimeEditText.text.clear()
                        Toast.makeText(this, "Screen time added successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Screen time must be a positive integer", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun clearData() {
            screenTimeData.clear()
            Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
        }

        fun navigateToDetailedViewActivity() {
            if (screenTimeData.isEmpty()) {
                Toast.makeText(this, "Please input screen time data first", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DetailedViewActivity::class.java).apply {
                    putIntegerArrayListExtra("ScreenTimeData", ArrayList(screenTimeData))
                }
                startActivity(intent)
            }
        }

        addButton.setOnClickListener {
            addScreenTime()
        }
        clearButton.setOnClickListener {
            clearData()
        }

        btnView.setOnClickListener {
            navigateToDetailedViewActivity()
        }
    }
}
