package com.zzy.studyproject.experiment.ju

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R

class ActivityJu:AppCompatActivity() {
    lateinit var button: Button

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity10)
        val activityJuBroadcastReceiver = ActivityJuBroadcastReceiver()
        val filter = IntentFilter("MY_RECEIVER1")
        init()
        registerReceiver(activityJuBroadcastReceiver,filter, RECEIVER_EXPORTED)

    }

    private fun init(){
        val intent = Intent("MY_RECEIVER1")
        button = findViewById(R.id.activity10_button_1)
        button.setOnClickListener {
            intent.putExtra("message","""
                2022451585316
                张振扬
            """.trimIndent())
            sendBroadcast(intent)
        }
    }
}