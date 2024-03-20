package com.zzy.studyproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ItemAdapter(context: Context, resource: Int, objects: List<String?>) :
    ArrayAdapter<String?>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val name = getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val itemName = view.findViewById<TextView>(R.id.item_name)
        assert(name != null)
        itemName.text = name
        return view
    }
}
