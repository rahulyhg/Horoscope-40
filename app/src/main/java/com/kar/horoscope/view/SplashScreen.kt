package com.kar.horoscope.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kar.horoscope.repository.SharedPrefPreferenceService
import com.kar.horoscope.view.activities.Forecast
import com.kar.horoscope.view.activities.MainActivity


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preference = getSharedPreferences("Preference", Context.MODE_PRIVATE)
        val sharedPrefPreferenceService = SharedPrefPreferenceService(preference)


        val id = sharedPrefPreferenceService.getPreference("Name", -1)
        val intent: Intent


        if (id != -1) {
            intent = Intent(this, Forecast::class.java)
            intent.putExtra("Title", id)
        }
        else
            intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        finish()
    }
}