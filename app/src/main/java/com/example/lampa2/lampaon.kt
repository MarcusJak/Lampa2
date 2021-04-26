package com.example.lampa2

import android.content.Intent
import android.net.MailTo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast


class lampaon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lampaon)


        //stäng av lampa

        val buttonOff = findViewById<Button>(R.id.buttonOff)

        buttonOff.setOnClickListener {
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
            writeData("2\n")
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
                Toast.makeText(this@lampaon,"ändring  ${endPoint-startPoint}%", Toast.LENGTH_SHORT).show()

            }

        })
        val rgbButton = findViewById<Button>(R.id.rgbButton)
        rgbButton.setOnClickListener {
            val intent = Intent(this,  RGB::class.java)
            startActivity(intent)
        }



        //sätt på UV
        val uvbutton = findViewById<Button>(R.id.uvbutton)

        uvbutton.setOnClickListener {
            val intent = Intent(this,  uvljus::class.java)
            startActivity(intent)
        }
        val btnsettings = findViewById<Button>(R.id.btnsettings)

        btnsettings.setOnClickListener {
            val intent = Intent(this,  settings::class.java)
            startActivity(intent)
        }

    }
}