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

        //sätt på lysset
        val onbutton = findViewById<Button>(R.id.onbutton)

        onbutton.setOnClickListener {
            val intent = Intent(this,  lampaon::class.java)
            writeData("1\n")
            startActivity(intent)
        }

        //sätt på UV
        val uvbutton = findViewById<Button>(R.id.uvbutton)

        uvbutton.setOnClickListener {
            val intent = Intent(this,  uvljus::class.java)
            startActivity(intent)
        }

        //sätt på UV
        val btnsettings = findViewById<Button>(R.id.btnsettings)

        btnsettings.setOnClickListener {
            val intent = Intent(this,  settings::class.java)
            startActivity(intent)
        }

    }
}