package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
            super.onCreate(savedInstanceState, persistentState)
            setContentView(R.layout.activity_main)

        val ScreenTimeData = mutableListOf<Int>()
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
                            ScreenTimeData.add(screenTime)
                            screenTimeEditText.text.clear()
                            Toast.makeText(
                                this,
                                "Screen time must be a positive integer",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this,
                                "Screen time must be a positive integer",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
                    }
                }
            }


            fun clearData() {
                ScreenTimeData.clear()
                Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
            }
            fun navigateToDetailedViewActivity(view: android.view.View) {
                if (ScreenTimeData.isEmpty()) {
                    Toast.makeText(this, "Please input screen time data first", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val intent = Intent(this, DetailedViewActivity::class.java).apply {
                        putIntegerArrayListExtra("ScreenTimeData", ArrayList(ScreenTimeData))
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
                startActivity(Intent(this,DetailedViewActivity::class.java))
            }
        }
    }
}

