package com.zzy.studyproject.experiment.go

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.zzy.studyproject.experiment.go.bean.ActivityGoRoomMate

@Composable
fun Easy(){
    LazyColumn{
        items(ActivityGoRoomMate.list){
            Text(text = it.name, color = if (it.clicked==1) Color.Blue else Color.Black)
        }
    }
}

@Composable
fun activity6(){
    Column {
        Row {
            Column {

            }
            Column {

            }
        }
    }
}