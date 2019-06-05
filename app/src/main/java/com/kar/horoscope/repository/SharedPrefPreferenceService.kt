package com.kar.horoscope.repository

import android.content.SharedPreferences
import com.kar.horoscope.models.Preference
import com.kar.horoscope.service.PreferenceService


class SharedPrefPreferenceService( private val storage : SharedPreferences ) : PreferenceService {

    override fun savePreference(preference: Preference)  {
        val editor= storage.edit()
        editor.putInt( preference.tag, preference.preference )
        editor.apply()
    }

    override fun getPreference(tag: String, defaultValue: Int ): Int {
        return storage.getInt( tag, defaultValue )
    }
}