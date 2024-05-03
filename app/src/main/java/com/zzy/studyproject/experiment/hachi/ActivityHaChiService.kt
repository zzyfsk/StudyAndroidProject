package com.zzy.studyproject.experiment.hachi

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ActivityHaChiService:Service() {
    private val TAG = "SERVICE"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: 已创建")
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Bind内容")
    }

}