package com.kar.horoscope.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kar.horoscope.service.PreferenceService

class SetUserZodiacViewModelFactory(private val preferenceService: PreferenceService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SetUserZodiacViewModel::class.java)) {
            return SetUserZodiacViewModel( preferenceService ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}