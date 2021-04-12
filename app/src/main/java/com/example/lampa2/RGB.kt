package com.example.lampa2

import android.content.Intent
import android.graphics.Color
import android.net.MailTo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast


class RGB : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_g_b)
        var red = 0
        var green = 0
        var blue = 0
        val view = findViewById<View>(R.id.rgbView)
        val sbR = findViewById<SeekBar>(R.id.redBar)
        val sbG = findViewById<SeekBar>(R.id.greenBar)
        val sbB = findViewById<SeekBar>(R.id.blueBar)
        val rT = findViewById<TextView>(R.id.redNumber)
        val gT = findViewById<TextView>(R.id.greenNumber)
        val bT = findViewById<TextView>(R.id.blueNumber)


        sbR.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                rT.text = progress.toString()
                red = progress
                view.setBackgroundColor(Color.rgb(red, green, blue))
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        sbG.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                gT.text = progress.toString()
                green = progress
                view.setBackgroundColor(Color.rgb(red, green, blue))
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        sbB.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                bT.text = progress.toString()
                blue = progress
                view.setBackgroundColor(Color.rgb(red, green, blue))
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }

}
