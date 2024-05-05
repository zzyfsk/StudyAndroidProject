package com.zzy.studyproject.experiment.kyu

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder

class CurrentTimeService:Service() {
    companion object {
        const val ACTION_TIME = "com.example.timeservice.ACTION_TIME"
        const val EXTRA_TIME = "com.example.timeservice.EXTRA_TIME"
    }

    private lateinit var handler: Handler
    private lateinit var timeRunnable: Runnable

    override fun onCreate() {
        super.onCreate()
        handler = Handler()
        timeRunnable = Runnable {
            // 发送当前时间广播
            val currentTime = System.currentTimeMillis().toString()
            val intent = Intent(ACTION_TIME)
            intent.putExtra(EXTRA_TIME, currentTime)
            println(currentTime)
            sendBroadcast(intent)

            // 每隔1秒发送一次
            handler.postDelayed(timeRunnable, 1000)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // 在Service启动时开始发送时间广播
        println("onStartCommand")
        handler.post(timeRunnable)
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        // 如果Service不支持绑定，可以返回null
        println("onBind")
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        // 停止发送时间广播
        handler.removeCallbacks(timeRunnable)
        println("onDestroy")
    }
}