package com.kar.horoscope.viewmodels

import android.arch.lifecycle.ViewModel
import com.kar.horoscope.models.Preference
import com.kar.horoscope.service.PreferenceService

class SetUserZodiacViewModel (private val preferenceService: PreferenceService) : ViewModel() {

    fun saveTheValue( preference: Preference ) {
        preferenceService.savePreference( preference )
    }

    fun getTheValue( tag: String, defaultValue: Int ) : Int {
        return preferenceService.getPreference( tag, defaultValue )
    }
}