package com.example.lampa2

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothSocket
import android.util.Log
import java.io.IOException
import java.util.*

val mBluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
lateinit var btSocket : BluetoothSocket
const val myUUID = "00001101-0000-1000-8000-00805F9B34FB"
fun connectBluetoothDevice() {
    val hC06 = mBluetoothAdapter?.getRemoteDevice("98:D3:32:71:17:DE") //Sätt in MAC-Adressen
    Log.d("", "Connecting to ... $hC06")
    mBluetoothAdapter?.cancelDiscovery()
    try {
        if (hC06 != null) {
            btSocket = hC06.createRfcommSocketToServiceRecord(UUID.fromString(myUUID))
        }
        btSocket.connect()
        Log.d("", "Connection made.")
    } catch (e: IOException) {
        try {
            btSocket.close()
        } catch (e2: IOException) {
            Log.d("", "Unable to end the connection")
        }
        Log.d("", "Socket creation failed")
    }
}

fun writeData(data: String) {
    try {
        btSocket.outputStream.write(data.toByteArray())
    }
    catch(e: IOException){
        e.printStackTrace()
    }
}