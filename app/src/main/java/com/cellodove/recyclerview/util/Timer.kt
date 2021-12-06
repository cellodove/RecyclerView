package com.cellodove.recyclerview.util

import android.os.CountDownTimer
import android.util.Log

class Timer(settingTime : Long, private val timeOut: () -> Unit){
    private val countDownTimer: CountDownTimer = object : CountDownTimer(settingTime,1000){
        override fun onTick(millisUntilFinished: Long) {
            Log.e("countDownTimer","countDownTimer 시간: $millisUntilFinished")
        }
        override fun onFinish() {
            Log.e("countDownTimer","countDownTimer 타임아웃")
            timeOut()
        }
    }
    fun start(){
        countDownTimer.start()
    }

    fun cancel(){
        countDownTimer.cancel()
    }
}