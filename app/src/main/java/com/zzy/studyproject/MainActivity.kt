package com.zzy.studyproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import com.zzy.studyproject.experiment.go.activity.ActivityGo
import com.zzy.studyproject.experiment.hachi.ActivityHaChi
import com.zzy.studyproject.experiment.ju.ActivityJu
import com.zzy.studyproject.experiment.juichi.ActivityJuIChi
import com.zzy.studyproject.experiment.jyuni.ActivityJyuNi
import com.zzy.studyproject.experiment.jyusan.ActivityJyuSan
import com.zzy.studyproject.experiment.jyuyon.ActivityJyuYon
import com.zzy.studyproject.experiment.kyu.ActivityKYu
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
    private var button9: Button? = null
    private var button10: Button? = null
    private var button11: Button? = null
    private var button12: Button? = null
    private var composeView: ComposeView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)
        initView()
        setListener()
        write()
        read()
        composeView?.setContent {
            val intent13 = Intent(this,ActivityJyuSan::class.java)
            val intent14 = Intent(this,ActivityJyuYon::class.java)
            Column {
                Button(onClick = { startActivity(intent13) }) {
                    Text(text = "去实验十三")
                }
                Button(onClick = { startActivity(intent14) }) {
                    Text(text = "去实验十四")
                }
            }
        }
    }

    private fun initView(){
        button3 = findViewById(R.id.main_button_3)
        button4 = findViewById(R.id.main_button_4)
        button5 = findViewById(R.id.main_button_5)
        button6 = findViewById(R.id.main_button_6)
        button7 = findViewById(R.id.main_button_7)
        button8 = findViewById(R.id.main_button_8)
        button9 = findViewById(R.id.main_button_9)
        button10 = findViewById(R.id.main_button_10)
        button11 = findViewById(R.id.main_button_11)
        button12 = findViewById(R.id.main_button_12)
        composeView = findViewById(R.id.activity_real_main_compose)
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
        button9?.setOnClickListener {
            val intent = Intent(this,ActivityKYu::class.java)
            this.startActivity(intent)
        }
        button10?.setOnClickListener {
            val intent = Intent(this,ActivityJu::class.java)
            this.startActivity(intent)
        }
        button11?.setOnClickListener {
            val intent = Intent(this,ActivityJuIChi::class.java)
            this.startActivity(intent)
        }
        button12?.setOnClickListener {
            val intent = Intent(this,ActivityJyuNi::class.java)
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