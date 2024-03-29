package com.zzy.studyproject.experiment.yon.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R

class ActivityYoN : AppCompatActivity() {

    private var textName: TextView? = null
    private var textId: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4)
        initText()
    }

    private fun initText(){
        textName = findViewById(R.id.activity4_text_name)
        textId = findViewById(R.id.activity4_text_id)
        textName?.text = intent.getStringExtra("name")
        textId?.text = intent.getStringExtra("id")
    }
}