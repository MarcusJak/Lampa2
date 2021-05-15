package com.example.lampa2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_r_g_b.*

class RGB : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_g_b)
        var red = 0
        var green = 0
        var blue = 0


        fun toHex(red : Int , green : Int, blue : Int) : String{
            var code = "#"
            code += Integer.toHexString(red)
            code += Integer.toHexString(green)
            code += Integer.toHexString(blue)
            return code
        }
        
        fun toRgb(red : Int , green : Int, blue : Int) : String{
            var code = "RGB ("
            val delimiter =  ", "
            code += red.toString()
            code += delimiter
            code += green.toString()
            code += delimiter
            code += blue.toString()
            code += ")"
            return code
        }
        rgbChoose.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        redBar.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                red = progress
                rgbView.setBackgroundColor(Color.rgb(red, green, blue))
                rgbHexValue.text = toHex(red, green, blue)
                rgbValue.text = toRgb(red, green, blue)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        greenBar.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                green = progress
                rgbView.setBackgroundColor(Color.rgb(red, green, blue))
                rgbHexValue.text = toHex(red, green, blue)
                rgbValue.text = toRgb(red, green, blue)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        blueBar.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                blue = progress
                rgbView.setBackgroundColor(Color.rgb(red, green, blue))
                rgbHexValue.text = toHex(red, green, blue)
                rgbValue.text = toRgb(red, green, blue)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?){}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

}
