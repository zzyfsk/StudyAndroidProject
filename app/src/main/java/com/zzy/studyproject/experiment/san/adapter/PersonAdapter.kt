package com.zzy.studyproject.experiment.san.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.san.bean.Person
import java.lang.RuntimeException

class PersonAdapter(
    private val context: Context, private val objects: List<Person>, val add: (Int) -> Unit,
    val toast: (String) -> Unit
) : BaseAdapter() {
    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(p0: Int): Person {
        return objects[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val person = getItem(position)
        val viewContent =
            LayoutInflater.from(context).inflate(R.layout.activity3item, parent, false)
        val itemName = viewContent?.findViewById<TextView>(R.id.item_text)
        val button = viewContent?.findViewById<Button>(R.id.item_button)
        itemName?.text = person.toString()
        button?.setOnClickListener {
            add(position)
            toast(getItem(position).toString())
            itemName?.text = getItem(position).toString()
        }
        return viewContent ?: throw RuntimeException("空view")
    }


}