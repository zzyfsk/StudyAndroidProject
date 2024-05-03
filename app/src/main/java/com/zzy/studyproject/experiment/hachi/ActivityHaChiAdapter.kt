package com.zzy.studyproject.experiment.hachi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.zzy.studyproject.R

class ActivityHaChiAdapter(
    private val context: Context, private val objects: List<Contacts>) : BaseAdapter() {
    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(p0: Int): Contacts {
        return objects[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewContent =
            LayoutInflater.from(context).inflate(R.layout.item7, parent, false)
        val itemName = viewContent?.findViewById<TextView>(R.id.item7_name)
        itemName?.text = "${getItem(position).name} ${getItem(position).number}"
        return viewContent ?: throw RuntimeException("空view")
    }


}