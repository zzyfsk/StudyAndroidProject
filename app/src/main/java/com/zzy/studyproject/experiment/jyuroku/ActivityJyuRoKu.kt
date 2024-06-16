package com.zzy.studyproject.experiment.jyuroku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ActivityJyuRoKu : AppCompatActivity() {
    var button: Button? = null
    var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity16)
        button = findViewById(R.id.activity16_button1)
        text = findViewById(R.id.activity16_text)

        button?.setOnClickListener {
            getFromSpringBoot("http://192.168.31.100:8080/hello")
        }
    }

    private fun getFromSpringBoot(ip: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(ip)
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                MainScope().launch {
                    Toast.makeText(this@ActivityJyuRoKu, "连接失败", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                runOnUiThread {
                    text?.text = responseBody
                }
                MainScope().launch {
                    Toast.makeText(this@ActivityJyuRoKu, "连接成功", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}