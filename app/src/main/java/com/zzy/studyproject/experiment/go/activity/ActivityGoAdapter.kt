package com.zzy.studyproject.experiment.go.activity

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.go.bean.ActivityGoRoomMate

class ActivityGoAdapter(
    private val context: Context,
    private val objects: List<ActivityGoRoomMate>,
    val change: (Int) -> Unit
) : BaseAdapter() {
    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(p0: Int): ActivityGoRoomMate {
        return objects[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val viewContent =
            LayoutInflater.from(context).inflate(R.layout.name_item_layout, p2, false)
        val button = viewContent?.findViewById<Button>(R.id.activity5_list_name)
        button?.text = getItem(p0).name
        button?.setTextColor(if (getItem(p0).clicked == 0) Color.BLUE else Color.BLACK)
        button?.setOnClickListener {
            change(p0)
            objects.forEachIndexed { index, _ ->
                if (index == p0) {
                    objects[index].clicked = 1
                    Log.e("TAG", "getView: ${objects[index].clicked}")
                } else {
                    objects[index].clicked = 0
                    Log.e("TAG", "getView: ${objects[index].clicked}")
                }
            }
            notifyDataSetChanged()
            if (getItem(p0).clicked == 0) Color.WHITE else Color.BLACK
        }

        return viewContent
    }

}