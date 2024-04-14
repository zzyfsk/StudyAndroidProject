package com.zzy.studyproject.experiment.go.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.go.Easy
import com.zzy.studyproject.experiment.go.bean.ActivityGoRoomMate


class FragmentGoIChi() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity5_fragment1, container, false)
        val listView = view.findViewById<ComposeView>(R.id.activity5_listview)
        listView!!.setContent {
            Easy()
        }

        return inflater.inflate(R.layout.activity5_fragment1, container, false)
    }
}