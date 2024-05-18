package com.zzy.studyproject.experiment.kyu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R

class ActivityKYu :AppCompatActivity(){
    private lateinit var timeTextView: TextView
    private val timeReceiver = TimeReceiver()

    inner class TimeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
                val time = intent.getStringExtra(CurrentTimeService.EXTRA_TIME)
                timeTextView.text = time
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity9)

        timeTextView = findViewById(R.id.activity9_text_1)

        val filter = IntentFilter(CurrentTimeService.ACTION_TIME)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(timeReceiver,filter, RECEIVER_NOT_EXPORTED)
            println("sure")
        }
        init()

    }

    private fun init(){
        val button = findViewById<Button>(R.id.activity9_button_1)
        button.setOnClickListener {
            val serviceIntent = Intent(this,CurrentTimeService::class.java)
            startService(serviceIntent)
        }
    }
}