package com.jccsisc.mytimertest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/****
 * Project: MyTimerTest
 * From: com.jccsisc.mytimertest
 * Created by Julio Cesar Camacho Silva on 31/01/2022 at 21:07
 * More info: https://www.facebook.com/juliocesar.camachosilva/
 * All rights reserved 2022.
 ***/
class MainViewModel: ViewModel() {

    val repository by lazy { Repository() }

    val _minutes: MutableLiveData<String> = MutableLiveData()
    val _seconds: MutableLiveData<String> = MutableLiveData()
    val _result: MutableLiveData<String> = MutableLiveData()

    val result: LiveData<String>
    get() = _result

    init {
        resetTime()
    }

    private fun resetTime() {
        _minutes.value = "0"
        _seconds.value = "0"
    }

    fun startTimer() {
        val min = _minutes.value!!
        val seg = _seconds.value!!

        viewModelScope.launch {
            repository.statTimerRepositoyy(min.toLong(), seg.toLong(), _result)
        }
    }

}