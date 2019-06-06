package com.kar.horoscope.viewmodels.compatibility

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kar.horoscope.service.CompatibilityService

class CompatibilityVMFactory( private val compatibilityService: CompatibilityService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(CompatibilityViewModel::class.java)) {
            return CompatibilityViewModel( compatibilityService ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}