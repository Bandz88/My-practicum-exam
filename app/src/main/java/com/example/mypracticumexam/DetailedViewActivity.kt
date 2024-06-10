package com.example.mypracticumexam

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {
    private lateinit var temperatures: Array<Float>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        temperatures = intent.getFloatArrayExtra("temperatures")!!.toTypedArray()
        val detailedInfo: TextView = findViewById(R.id.detailedInfo)

        detailedInfo.text = """
            Day 1: ${temperatures[0]} °C
            Day 2: ${temperatures[1]} °C
            Day 3: ${temperatures[2]} °C
            Day 4: ${temperatures[3]} °C
            Day 5: ${temperatures[4]} °C
            Day 6: ${temperatures[5]} °C
            Day 7: ${temperatures[6]} °C
        """.trimIndent()

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
