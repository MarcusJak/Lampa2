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
        val hexV = findViewById<TextView>(R.id.rgbHexValue)
        val rgbV = findViewById<TextView>(R.id.rgbValue)
        val view = findViewById<View>(R.id.rgbView)
        val sbR = findViewById<SeekBar>(R.id.redBar)
        val sbG = findViewById<SeekBar>(R.id.greenBar)
        val sbB = findViewById<SeekBar>(R.id.blueBar)



        fun toHex(red : Int , green : Int, blue : Int) : String{
            var code = "#"
            code += java.lang.Integer.toHexString(red)
            code += java.lang.Integer.toHexString(green)
            code += java.lang.Integer.toHexString(blue)
            return code
        }
        
        fun toRgb(red : Int , green : Int, blue : Int) : String{
            var code = "RGB ("
            val delim =  ", "
            code += red.toString()
            code += delim
            code += green.toString()
            code += delim
            code += blue.toString()
            code += ")"
            return code
        }

        sbR.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                red = progress
                view.setBackgroundColor(Color.rgb(red, green, blue))
                hexV.text = toHex(red, green, blue)
                rgbV.text = toRgb(red, green, blue)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        sbG.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                green = progress
                view.setBackgroundColor(Color.rgb(red, green, blue))
                hexV.text = toHex(red, green, blue)
                rgbV.text = toRgb(red, green, blue)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        sbB.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                blue = progress
                view.setBackgroundColor(Color.rgb(red, green, blue))
                hexV.text = toHex(red, green, blue)
                rgbV.text = toRgb(red, green, blue)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

}
