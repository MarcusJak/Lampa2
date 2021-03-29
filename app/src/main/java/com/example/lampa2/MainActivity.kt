package com.example.lampa2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rgbButton = findViewById<Button>(R.id.rgbButton)
        rgbButton.setOnClickListener {
            val intent = Intent(this,  RGB::class.java)
            startActivity(intent)
        }

    }
}