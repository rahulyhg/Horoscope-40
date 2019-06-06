package com.kar.horoscope.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.kar.horoscope.R
import com.kar.horoscope.repository.fragmentadapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_forecast.*

class Forecast : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        val intent = intent
        val id = intent.getIntExtra( "Title", 0 )
        val list = resources.getStringArray(R.array.Zodiacs).toList()
        title = list[id]


        val myPagerAdapter = MainPagerAdapter ( supportFragmentManager, applicationContext )
        viewPager.adapter = myPagerAdapter
        viewPager.setCurrentItem(1, true )

        tabLayout.setupWithViewPager( viewPager )
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent( this, MainActivity::class.java))
        finish()
    }
}
