package com.zzy.studyproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.experiment.go.activity.ActivityGo
import com.zzy.studyproject.experiment.hachi.ActivityHaChi
import com.zzy.studyproject.experiment.nana.ActivityNaNa
import com.zzy.studyproject.experiment.roku.activity.ActivityRoKu
import com.zzy.studyproject.experiment.san.activity.ActivitySaN
import com.zzy.studyproject.experiment.yon.activity.ActivityYoN


class MainActivity : AppCompatActivity() {

    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)
        initView()
        setListener()
        write()
        read()
    }

    private fun initView(){
        button3 = findViewById(R.id.main_button_3)
        button4 = findViewById(R.id.main_button_4)
        button5 = findViewById(R.id.main_button_5)
        button6 = findViewById(R.id.main_button_6)
        button7 = findViewById(R.id.main_button_7)
        button8 = findViewById(R.id.main_button_8)
    }

    private fun setListener(){
        button3?.setOnClickListener{
            val intent = Intent(this, ActivitySaN::class.java)
            intent.putExtra("ActivityMain","From MainActivity")
            this.startActivity(intent)
        }
        button4?.setOnClickListener{
            val intent = Intent(this, ActivityYoN::class.java)
            intent.putExtra("name","张振扬")
            intent.putExtra("id","2022451585316")
            this.startActivity(intent)
        }
        button5?.setOnClickListener{
            val intent = Intent(this, ActivityGo::class.java)
            this.startActivity(intent)
        }
        button6?.setOnClickListener{
            val intent = Intent(this, ActivityRoKu::class.java)
            this.startActivity(intent)
        }
        button7?.setOnClickListener{
            val intent = Intent(this, ActivityNaNa::class.java)
            this.startActivity(intent)
        }
        button8?.setOnClickListener {
            val intent = Intent(this,ActivityHaChi::class.java)
            this.startActivity(intent)
        }
    }

    private fun write(){
        val sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("key", "value")
        editor.apply()
    }

    private fun read(){
        val sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)
        val value = sharedPreferences.getString("key", null)
        println(value?:throw RuntimeException("获取失败"))
    }
}