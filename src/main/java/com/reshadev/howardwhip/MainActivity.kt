package com.reshadev.howardwhip

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.hardware.SensorManager
import android.media.SoundPool
import android.widget.Toast
import com.squareup.seismic.ShakeDetector


class MainActivity : AppCompatActivity(), ShakeDetector.Listener {
    private var sensorManager:SensorManager?=null
    private var shakeDetector:ShakeDetector= ShakeDetector(this)
    var mcSoundId:Int=0
    lateinit var soundPool: SoundPool

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager=getSystemService(SENSOR_SERVICE) as SensorManager
        shakeDetector.start(sensorManager)
        soundPool=SoundPool.Builder().setMaxStreams(5).build()
        mcSoundId=soundPool.load(this,R.raw.whip,1)
    }


    override fun hearShake() {
        soundPool.play(mcSoundId,1.0f,1.0f,1,0,1.0f)
        Toast.makeText(this,"Did You Just Say \'SPACE\'????",Toast.LENGTH_SHORT).show()



    }


}