package com.zzy.studyproject.experiment.go.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.go.Easy

class ActivityGo : AppCompatActivity() {

    val list = listOf("张三","李四","王五")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity5)
        val fragment1 = findViewById<ComposeView>(R.id.activity5_fragment1)
        val fragment2 = FragmentGoINi()
        val tran = supportFragmentManager.beginTransaction()
        tran.add(R.id.activity5_fragment2,fragment2)
        tran.commit()
        fragment1.setContent {
            Easy()
        }


    }
}