package com.zzy.studyproject

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.experiment.ni.adapter.PersonAdapter
import com.zzy.studyproject.experiment.ni.bean.Person

class MainActivity : AppCompatActivity() {

    private val list = listOf(
        Person("张三"),
        Person("李四"),
        Person("王五"),
        Person("六六"),
        Person("七七"),
        Person("八八"),
        Person("九九九"),
        Person("十十十十"),

    )

    private var listView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_2)
        val adapter = PersonAdapter(this, list, {
            list[it].times++
        }) {
            toast(it)
        }
        listView = findViewById(R.id.list)
        listView?.adapter = adapter

    }

    private fun MainActivity.toast(string: String) {
        val toast = Toast.makeText(this, string, Toast.LENGTH_LONG)
        toast.show()
    }
}