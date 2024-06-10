package com.example.mypracticumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var temperatures: Array<Float>
    private lateinit var averageTempTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temperatures = Array(7) { 0.0f }
        averageTempTextView = findViewById(R.id.averageTempTextView)

        val tempDay1: EditText = findViewById(R.id.tempDay1)
        // Repeat for tempDay2 to tempDay7
        val tempDay7: EditText = findViewById(R.id.tempDay7)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        val detailedViewButton: Button = findViewById(R.id.detailedViewButton)
        val clearButton: Button = findViewById(R.id.clearButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        calculateButton.setOnClickListener {
            temperatures[0] = tempDay1.text.toString().toFloatOrNull() ?: 0.0f
            // Repeat for temperatures[1] to temperatures[6]
            temperatures[6] = tempDay7.text.toString().toFloatOrNull() ?: 0.0f
            calculateAverageTemperature()
        }

        detailedViewButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putExtra("temperatures", temperatures)
            startActivity(intent)
        }

        clearButton.setOnClickListener {
            clearData(tempDay1, tempDay7) // Pass all tempDay variables
        }

        exitButton.setOnClickListener {
            finish()
        }
    }

    private fun calculateAverageTemperature() {
        val sum = temperatures.sum()
        val average = sum / temperatures.size
        averageTempTextView.text = "Average Temperature: $average °C"
    }

    private fun clearData(vararg tempInputs: EditText) {
        temperatures.fill(0.0f)
        tempInputs.forEach { it.text.clear() }
    }
}
