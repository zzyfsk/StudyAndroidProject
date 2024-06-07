package com.zzy.studyproject.experiment.jyuyon

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R
import java.io.IOException

class ActivityJyuYon : AppCompatActivity() ,SurfaceHolder.Callback{
    private var videoView: VideoView? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var surfaceView: SurfaceView? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var mediaPlayer:MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity14)
        init()
    }

    private fun init() {
        videoView = findViewById(R.id.activity14_videoView)
        button1 = findViewById(R.id.activity14_button1)
        button2 = findViewById(R.id.activity14_button2)
        button3 = findViewById(R.id.activity14_button3)
        surfaceView = findViewById(R.id.activity14_surfaceView)
        button4 = findViewById(R.id.activity14_button4)
        button5 = findViewById(R.id.activity14_button5)
        button6 = findViewById(R.id.activity14_button6)
        mediaPlayer = MediaPlayer()
        val surfaceHolder = surfaceView?.holder
        surfaceHolder?.addCallback(this)

        videoView?.setVideoPath("android.resource://" + packageName + "/" + R.raw.recording)
        button1?.setOnClickListener {
            videoView?.start()
        }
        button2?.setOnClickListener {
            videoView?.pause()
        }
        button3?.setOnClickListener {
            videoView?.stopPlayback()
        }
        mediaPlayer?.setOnPreparedListener {
            mediaPlayer?.start()
        }
    }
    override fun surfaceCreated(holder: SurfaceHolder) {
        try {
            val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.recording)
            mediaPlayer?.setDataSource(this, videoUri)
            mediaPlayer?.setDisplay(holder)
            mediaPlayer?.prepareAsync()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        mediaPlayer?.release()
    }
}