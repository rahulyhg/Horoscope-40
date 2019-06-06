package com.kar.horoscope.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kar.horoscope.R
import com.kar.horoscope.service.ItemClickedCallback

class Compatibility : AppCompatActivity(), ItemClickedCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compatibility)
    }

    override fun itemClicked() {

    }

}
