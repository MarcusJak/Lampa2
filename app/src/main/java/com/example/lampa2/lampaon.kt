package com.example.lampa2

import android.content.Intent
import android.net.MailTo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class lampaon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lampaon)


        //stäng av lampa

        val buttonOff = findViewById<Button>(R.id.buttonOff)

        buttonOff.setOnClickListener {
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }
    }
}