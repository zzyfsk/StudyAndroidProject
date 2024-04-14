package com.zzy.studyproject.experiment.go.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.go.bean.ActivityGoRoomMate


class FragmentGoINi : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity5_fragment2, container, false)
    }
}