package com.example.lampa2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RGB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_g_b)

        val actionBar = supportActionBar
        actionBar!!.title = "RGB Picker"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}