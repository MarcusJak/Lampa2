package com.example.lampa2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnnightmode = findViewById<Button>(R.id.btnnightmode)

        btnnightmode.setOnClickListener {
        }

        val btnpresets = findViewById<Button>(R.id.btnpresets)

        btnpresets.setOnClickListener {
            val intent = Intent(this,  presets::class.java)
            startActivity(intent)
        }

    }
}