package com.zzy.studyproject.experiment.jyuni

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zzy.studyproject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityJyuNi:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity12)
        val composeView = findViewById<ComposeView>(R.id.activity12_compose)
        composeView.setContent {
            val coroutineScope = rememberCoroutineScope()
            val viewModel:JyuNiViewModel = viewModel()
            viewModel.port = "9999"
            Column {
                Row {
                    Button(onClick = {
                        lifecycleScope.async(){
                            viewModel.toggleConnection()
                        }
                    }) {
                        Text(text = "连接服务器")
                    }
                    Text(text = viewModel.ip)
                }
                LazyColumn {
                    items(viewModel.textList){
                        Text(text = it)
                    }
                }
            }
        }
    }
}