package com.example.lampa2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class uvljus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uvljus)


        //stäng av uv
        val uvOff = findViewById<Button>(R.id.uvOff)

        uvOff.setOnClickListener {
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        }
        val styrka = findViewById<SeekBar>(R.id.styrka)
        val textView2 = findViewById<TextView>(R.id.textView2)
        var startPoint=0
        var endPoint=0

        styrka.setOnSeekBarChangeListener(object :  SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView2.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    startPoint=seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    endPoint=seekBar.progress
                }
                Toast.makeText(this@uvljus,"ändring  ${endPoint-startPoint}%", Toast.LENGTH_SHORT).show()

            }

        })
    }
}