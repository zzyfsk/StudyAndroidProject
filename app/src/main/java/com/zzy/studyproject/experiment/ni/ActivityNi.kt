package com.zzy.studyproject.experiment.ni

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R

class ActivityNi:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)

        val string = intent.getStringExtra("ActivityMain")
        Log.i("作业内容", "onCreate: $string")
    }

}