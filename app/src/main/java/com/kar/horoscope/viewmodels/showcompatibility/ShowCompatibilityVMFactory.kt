package com.kar.horoscope.viewmodels.showcompatibility

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kar.horoscope.service.ShowService

class ShowCompatibilityVMFactory (private val showService: ShowService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowCompatibilityViewModel::class.java)) {
            return ShowCompatibilityViewModel(showService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}