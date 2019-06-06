package com.kar.horoscope.viewmodels.forecast

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kar.horoscope.service.FirebaseService

class ForecastVMFactory(private val firebaseService: FirebaseService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ForecastViewModel::class.java)) {
            return ForecastViewModel(firebaseService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}