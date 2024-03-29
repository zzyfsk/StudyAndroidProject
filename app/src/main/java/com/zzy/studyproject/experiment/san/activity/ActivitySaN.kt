package com.zzy.studyproject.experiment.san.activity

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.san.adapter.PersonAdapter
import com.zzy.studyproject.experiment.san.bean.Person

class ActivitySaN:AppCompatActivity() {
    private val list = listOf(
        Person("张三"),
        Person("李四"),
        Person("王五"),
        Person("六六"),
        Person("七七"),
        Person("八八"),
        Person("九九九"),
        Person("十十十十"),
        Person("2022433225423"),
        Person("张振扬")
    )

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)
        //将函数传入adapter以修改数据源
        val adapter = PersonAdapter(this, list, {
            list[it].times++
        }) {
            toast(it)
        }
        listView = findViewById(R.id.list)
        listView?.adapter = adapter
    }

    private fun ActivitySaN.toast(string: String) {
        val toast = Toast.makeText(this, string, Toast.LENGTH_LONG)
        toast.show()
    }
}