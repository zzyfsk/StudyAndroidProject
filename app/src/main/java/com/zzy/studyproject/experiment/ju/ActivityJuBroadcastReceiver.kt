package com.zzy.studyproject.experiment.ju

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ActivityJuBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "广播：${p1?.getStringExtra("message")}", Toast.LENGTH_LONG)
            .show()
        Log.e("TAG", "onReceive: ddd")
    }

}