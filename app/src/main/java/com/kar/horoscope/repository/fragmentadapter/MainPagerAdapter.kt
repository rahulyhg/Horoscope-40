package com.kar.horoscope.repository.fragmentadapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kar.horoscope.R
import com.kar.horoscope.view.PostFragment


internal class MainPagerAdapter(fm: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fm) {

    private val dates: Array<String> = context.resources.getStringArray(R.array.date)


    override fun getItem(position: Int): Fragment {
        return PostFragment().newInstance(position)
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return dates[position]
    }
}