package com.example.my.homework_1_month7

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Default).launch {
            runSec()
        }

        CoroutineScope(Dispatchers.Default).launch {
            runTimer(30)
        }
    }

    private fun runSec() {
        var sec = 0
        var min = 0
        var hour = 0
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                if (min >= 60) {
                    hour++
                    min = 0
                }
                if (sec >= 60) {
                    min++
                    sec = 0
                }

                val time = String.format("%d:%02d:%02d", hour, min, sec)
                Log.d("ololo", "sec: $time")
                sec++
            }

        }, 0, 1000)
    }

    private fun runTimer(time: Long) {
        var time1 = time
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                time1--
                Log.d("Tash", "timer: $time1")
                if (time1 <= 0) {
                    Log.d("Tash", "run: timer finish")
                    this.cancel()
                }
            }
        }, 0, 1000)
    }

}