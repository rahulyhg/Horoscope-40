package com.kar.horoscope.viewmodels.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kar.horoscope.service.MainService

class ViewModelFactory(private val mainService: MainService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mainService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}