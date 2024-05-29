package com.zzy.studyproject.experiment.jyusan

import android.content.Context
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.zzy.studyproject.R

class JyuSanViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null
    private var soundPool: SoundPool? = null
    private var soundId: Int? = null

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun setupMediaPlayer(context: Context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.write)
    }

    fun playMusicWithMediaPlay(context: Context) {
        if (!mediaPlayer?.isPlaying!!) {
            mediaPlayer?.start()
            toast(context,"1播放成功")
        } else {
            mediaPlayer?.pause()
        }
    }

    fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun setupSoundPool(context: Context) {
        soundPool = SoundPool.Builder().setMaxStreams(1).build()
        soundId = soundPool?.load(context, R.raw.write, 1)
    }

    fun playSoundWithSoundPool(context: Context) {
        soundPool?.setOnLoadCompleteListener { soundPool, _, _ ->
                soundId?.let { soundPool.play(it, 1.0f, 1.0f, 0, 0, 1.0f) }
                toast(context,"2播放成功")
        }
        soundPool?.play(soundId!!, 1.0f, 1.0f, 0, 0, 1.0f)
        toast(context,"2播放成功")
    }

    private fun toast(context: Context, msg:String){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()
    }
}