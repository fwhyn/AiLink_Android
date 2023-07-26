package com.fwhyn.ailink

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fwhyn.ailink.Constants.TAG
import com.pingwang.bluetoothlib.AILinkBleManager
import com.pingwang.bluetoothlib.AILinkBleManager.onInitListener

import com.pingwang.bluetoothlib.AILinkSDK


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        AILinkSDK.getInstance().init(this)
        AILinkBleManager.getInstance().init(this, object : onInitListener {
            override fun onInitSuccess() {
                Log.d(TAG, javaClass.name + " " + "init success")
            }

            override fun onInitFailure() {
                Log.d(TAG, javaClass.name + " " + "init failure")
            }
        })
    }
}