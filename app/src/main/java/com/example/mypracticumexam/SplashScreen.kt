package com.example.mypracticumexam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val StartUpBtn: Button = findViewById(R.id.StartUpBtn)
        val LeaveAppBtn: Button = findViewById(R.id.LeaveAppBtn)


        StartUpBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        LeaveAppBtn.setOnClickListener {
            finish()
        }
    }
}
