package com.zzy.studyproject.experiment.go.bean

import com.zzy.studyproject.R

data class ActivityGoRoomMate(val imageId: Int, val name: String = "",var clicked:Int = 0) {
    companion object {
        val list = listOf(
            ActivityGoRoomMate(R.drawable.a, "张三",1),
            ActivityGoRoomMate(R.drawable.b, "李四",0)
        )
    }
}
