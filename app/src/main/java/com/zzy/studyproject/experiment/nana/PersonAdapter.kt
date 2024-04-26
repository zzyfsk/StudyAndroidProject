package com.zzy.studyproject.experiment.nana

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.roku.bean.Student
import com.zzy.studyproject.experiment.san.bean.Person
import java.lang.RuntimeException

class EditAdapter(
    private val context: Context, private val objects: List<Student>, val add: (Int) -> Unit,
    val toast: (String) -> Unit
) : BaseAdapter() {
    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(p0: Int): Student {
        return objects[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewContent =
            LayoutInflater.from(context).inflate(R.layout.item7, parent, false)
        val itemName = viewContent?.findViewById<TextView>(R.id.item7_name)
        itemName?.text = getItem(position).toString()
        return viewContent ?: throw RuntimeException("空view")
    }


}