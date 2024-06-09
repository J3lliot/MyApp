package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.widget.Button
import android.widget.TextView
import kotlin.system.exitProcess

class DetailedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val exitBtn = findViewById<Button>(R.id.button2)
        val backBtn = findViewById<Button>(R.id.backBtn)
        val averageTextView = findViewById<TextView>(R.id.average)
        val detailedView = findViewById<TextView>(R.id.detailedView)
        val ScreenTimeData = mutableListOf<Int>()

        intent.getIntegerArrayListExtra("ScreenTimeData")?.let{ ScreenTimeData.addAll(it)}

        fun displayDetailedView(){
            val detailedViewText = StringBuilder()
            for ((index, screenTime) in ScreenTimeData.withIndex()){
                detailedViewText.append("Day ${index + 1}: $screenTime minutes\n")
            }
            detailedView.text = detailedViewText.toString()
        }

         fun calculateAverage() {
            val totalScreenTime =ScreenTimeData.sum()
            val averageScreenTime = if(ScreenTimeData.isNotEmpty()){
                totalScreenTime / ScreenTimeData.size
            } else{
                0
            }
            averageTextView.text = "Average screen time: $averageScreenTime minutes"
        }

        displayDetailedView()
        calculateAverage()

        backBtn.setOnClickListener {
            finish()
        }
        exitBtn.setOnClickListener {
            Process.killProcess(Process.myPid())
            exitProcess(1)
        }
    }
}