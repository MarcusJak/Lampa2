package com.example.lampa2

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*

lateinit var btSocket : BluetoothSocket

class MainActivity : AppCompatActivity() {

    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var macstring : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        macstring = intent.getStringExtra("MAC-Address").toString()
        connect()

        rgbButton.setOnClickListener {
            val intent = Intent(this,  RGB::class.java)
            startActivity(intent)
        }

        //Sätt på lysset
        onbutton.setOnClickListener {
            writeData("1")
            val intent = Intent(this,  lampaon::class.java)
            startActivity(intent)
        }

        //sätt på UV
        uvbutton.setOnClickListener {
            val intent = Intent(this,  uvljus::class.java)
            writeData("3")
            startActivity(intent)
        }

        //sätt på UV
        btnsettings.setOnClickListener {
            val intent = Intent(this,  settings::class.java)
            startActivity(intent)
        }

    }
    fun connect() {
        val device = mBluetoothAdapter.getRemoteDevice(macstring)
        Log.d("", "Connecting to ... $device")
        mBluetoothAdapter.cancelDiscovery()
        try {
            btSocket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
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
    }

    private fun writeData(data: String) {
        val outStream = btSocket.outputStream
        val msgBuffer = data.toByteArray()
        outStream.write(msgBuffer)
    }
}