package com.example.lampa2

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select_device.*
import org.jetbrains.anko.toast
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

lateinit var btSocket : BluetoothSocket
lateinit var macstring : String
lateinit var device : BluetoothDevice
lateinit var m_bluetoothAdapter: BluetoothAdapter

class SelectDevice : AppCompatActivity() {

    private lateinit var m_pairedDevices: Set<BluetoothDevice>
    private val REQUEST_ENABLE_BLUETOOTH = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_device)

        m_bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if(!m_bluetoothAdapter.isEnabled) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, REQUEST_ENABLE_BLUETOOTH)
        }

        selectDeviceRefresh.setOnClickListener{ pairedDeviceList() }

    }

    private fun pairedDeviceList() {
        m_pairedDevices = m_bluetoothAdapter.bondedDevices
        val list : ArrayList<BluetoothDevice> = ArrayList()

        if (m_pairedDevices.isNotEmpty()) {
            for (device: BluetoothDevice in m_pairedDevices) {
                list.add(device)
                Log.i("device", ""+device)
            }
        } else {
            toast("no paired bluetooth devices found")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        selectDeviceList.adapter = adapter
        selectDeviceList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val device: BluetoothDevice = list[position]
            macstring = device.address
            Log.i("MACADRESS", macstring)
            connect()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ENABLE_BLUETOOTH) {
            if (resultCode == Activity.RESULT_OK) {
                if (m_bluetoothAdapter.isEnabled) {
                    toast("Bluetooth has been enabled")
                } else {
                    toast("Bluetooth has been disabled")
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                toast("Bluetooth enabling has been canceled")
            }
        }
    }
}

fun connect() {
    device = m_bluetoothAdapter.getRemoteDevice(macstring)
    Log.d("", "Connecting to ... $device")
    m_bluetoothAdapter.cancelDiscovery()
    try {
        btSocket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
        btSocket.connect()
    } catch (e: IOException) {
        try {
            btSocket.close()
        } catch (e2: IOException) {
            Log.d("", "Unable to end the connection")
        }
    }
}