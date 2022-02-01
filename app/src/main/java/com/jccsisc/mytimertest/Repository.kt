package com.jccsisc.mytimertest

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData

/****
 * Project: MyTimerTest
 * From: com.jccsisc.mytimertest
 * Created by Julio Cesar Camacho Silva on 31/01/2022 at 21:07
 * More info: https://www.facebook.com/juliocesar.camachosilva/
 * All rights reserved 2022.
 ***/
class Repository {

    lateinit var countDownTimer: CountDownTimer

    fun statTimerRepositoyy(min: Long, seg: Long, result: MutableLiveData<String>?) {
        val timeMiliis = (min * 60000) + (seg * 1000)

        countDownTimer = object : CountDownTimer(timeMiliis, 1000) {

            override fun onTick(millisUntilFinished: Long) {
               var timeMilisDif = millisUntilFinished

                val secondMiliss: Long = 1000
                val minutesMiliss = secondMiliss * 60

                val minusTimerTrans = timeMilisDif / minutesMiliss
                timeMilisDif %= minutesMiliss

                val secondsTimerTrans = timeMilisDif / secondMiliss

                result?.postValue("${minusTimerTrans.formatHr()}:${secondsTimerTrans.formatHr()}")

            }


            override fun onFinish() {
                result?.postValue("00.00")
            }

        }.start()
    }
}

fun Long.formatHr() = run {
    if ((this / 10) == 0L) {
        "0$this"
    }else {
        this
    }
}