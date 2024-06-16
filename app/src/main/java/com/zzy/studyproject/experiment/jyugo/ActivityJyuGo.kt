package com.zzy.studyproject.experiment.jyugo

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zzy.studyproject.R
import kotlinx.coroutines.launch

class ActivityJyuGo : AppCompatActivity() {
    private var textView: TextView? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null

    private val updateMsg = 1
    private val mHandler: Handler = Handler(object : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            when (msg.what) {
                updateMsg -> {
                    textView?.text = msg.obj as String
                    return true
                }
            }
            return false
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity15)
        textView = findViewById(R.id.activity15_text)
        button1 = findViewById(R.id.activity15_button1)
        button2 = findViewById(R.id.activity15_button2)
        button3 = findViewById(R.id.activity15_button3)

        button1?.setOnClickListener {
            lifecycleScope.launch {
                textView?.text = "2022451585316 张振扬"
            }
        }

        button2?.setOnClickListener {
            val msg = Message()
            msg.what = updateMsg
            msg.obj = "2022451585316 张振扬"
            mHandler.sendMessage(msg)
        }

        button3?.setOnClickListener {
            mHandler.postDelayed({
                textView?.text = "2022451585316 张振扬 延迟更新"
            }, 2000)

        }
    }
}