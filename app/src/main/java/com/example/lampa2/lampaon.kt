package com.example.lampa2

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.net.MailTo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.util.*


class lampaon : AppCompatActivity() {
    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var btSocket : BluetoothSocket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lampaon)


        //stäng av lampa

        val buttonOff = findViewById<Button>(R.id.buttonOff)

        buttonOff.setOnClickListener {
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
    fun Connect() {

        val device = mBluetoothAdapter.getRemoteDevice("30:14:08:26:16:18")
        Log.d("", "Connecting to ... $device")
        mBluetoothAdapter.cancelDiscovery()
        try {
            btSocket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
            /* Here is the part the connection is made, by asking the device to create a RfcommSocket (Unsecure socket I guess), It map a port for us or something like that */
            btSocket.connect()
        } catch (e: IOException) {
            try {
                btSocket.close()
            } catch (e2: IOException) {
                Log.d("", "Unable to end the connection")
                Toast.makeText(applicationContext, "Unable to end the connection", Toast.LENGTH_SHORT).show()
            }

            Log.d("", "Socket creation failed")
            Toast.makeText(applicationContext, "Socket creation failed", Toast.LENGTH_SHORT).show()
        }

        //beginListenForData()
        /* this is a method used to read what the Arduino says for example when you write Serial.print("Hello world.") in your Arduino code */
    }

    private fun writeData(data: String) {
        var outStream = btSocket.outputStream
        try {
            outStream = btSocket.outputStream
        } catch (e: IOException) {
            //Log.d(FragmentActivity.TAG, "Bug BEFORE Sending stuff", e)
        }
        val msgBuffer = data.toByteArray()

        try {
            outStream.write(msgBuffer)
        } catch (e: IOException) {
            //Log.d(FragmentActivity.TAG, "Bug while sending stuff", e)
        }

    }
}