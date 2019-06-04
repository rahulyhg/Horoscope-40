package com.kar.horoscope.service

import com.kar.horoscope.models.Preference
import io.reactivex.Observable

interface PreferenceService {
    fun savePreference( preference: Preference )
    fun getPreference( tag: String, defaultValue: Int ) : Int
}