package com.example.lampa2

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.lang.reflect.Method
import java.util.*


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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


    private fun writeData(data: String) {
        val outStream = btSocket.outputStream
        val msgBuffer = data.toByteArray()
        outStream.write(msgBuffer)
    }
}
fun isConnected(device: BluetoothDevice): Boolean {
    return try {
        val m: Method = device.javaClass.getMethod("isConnected")
        m.invoke(device) as Boolean}
    catch (e: Exception) {throw IllegalStateException(e)}
}