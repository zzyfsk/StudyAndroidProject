package com.zzy.studyproject.experiment.jyusan

import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R

class ActivityJyuSan:AppCompatActivity() {

    private var button1:Button? = null
    private var button2:Button? = null
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity13)
        val viewModel:JyuSanViewModel by viewModels()
        viewModel.setupMediaPlayer(this)
        viewModel.setupSoundPool(this)
        button1 = findViewById(R.id.activity13_button_1)
        button2 = findViewById(R.id.activity13_button_2)
        button1?.setOnClickListener {
            viewModel.playMusicWithMediaPlay(this)
        }
        button2?.setOnClickListener {
            viewModel.playSoundWithSoundPool(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val viewModel:JyuSanViewModel by viewModels()
        viewModel.stopMusic()
    }

}