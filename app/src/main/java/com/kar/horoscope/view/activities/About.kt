package com.kar.horoscope.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kar.horoscope.R

class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "About"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent ( this, MainActivity::class.java ))
        finish()
    }
}
