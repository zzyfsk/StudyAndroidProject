package com.zzy.studyproject.experiment.juichi

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zzy.studyproject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class ActivityJuIChi : AppCompatActivity() {
    var htmlData:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity11)

        val webView = findViewById<WebView>(R.id.activity11_webview)
        val button = findViewById<Button>(R.id.activity11_button_1)

        val webSettings = webView.settings

        webSettings.javaScriptEnabled = true // 允许JavaScript执行
        val url = "https://www.baidu.com" // 替换为目标网址
        htmlData = loadHtmlFromUrl(url)
        button.setOnClickListener {
            webView.loadDataWithBaseURL(null, htmlData!!, "text/html", "utf-8", null)
        }
    }

    private fun loadHtmlFromUrl(urlWeb: String): String {
        val htmlContent = StringBuilder()
        try {
            val url = URL(urlWeb)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    val inputStream = BufferedInputStream(connection.inputStream)
                    val reader = BufferedReader(InputStreamReader(inputStream))
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        htmlContent.append(line)
                    }
                    reader.close()
                    Log.e("TAG", "loadHtmlFromUrl: $htmlContent" )
                    htmlData = htmlContent.toString()
                }
            }
            connection.disconnect()
            Log.e("TAG", "loadHtmlFromUrl: $htmlContent" )

        } catch (e: IOException) {
            println(e.localizedMessage)
        }
        return htmlContent.toString()
    }

}