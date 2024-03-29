package com.zzy.studyproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.experiment.ni.ActivityNi
import com.zzy.studyproject.experiment.san.activity.ActivitySaN
import com.zzy.studyproject.experiment.yon.activity.ActivityYoN

class MainActivity : AppCompatActivity() {

    private var button3: Button? = null
    private var button4: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)
        initView()
        setListener()
    }

    private fun initView(){
        button3 = findViewById(R.id.main_button_3)
        button4 = findViewById(R.id.main_button_4)
    }

    private fun setListener(){
        button3?.setOnClickListener{
            val intent = Intent(this, ActivityNi::class.java)
            intent.putExtra("ActivityMain","From MainActivity")
            this.startActivity(intent)
        }
        button4?.setOnClickListener{
            val intent = Intent(this, ActivityYoN::class.java)
            intent.putExtra("name","张振扬")
            intent.putExtra("id","2022451585316")
            this.startActivity(intent)
        }
    }
}