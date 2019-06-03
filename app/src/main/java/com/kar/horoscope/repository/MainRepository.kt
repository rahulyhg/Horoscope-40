package com.kar.horoscope.repository

import android.content.Context
import com.kar.horoscope.R
import com.kar.horoscope.models.MainViewZodiacModel
import com.kar.horoscope.service.MainService
import io.reactivex.Observable

class MainRepository(private val context: Context) : MainService {

    override fun generateNames(): List<String> {
        return context.resources.getStringArray(R.array.Zodiacs).toList()
    }

    override fun generateImages(): List<Int> {

        return listOf(
            R.drawable.logo_aries,
            R.drawable.logo_taurus,
            R.drawable.logo_gemini,
            R.drawable.logo_cancer,
            R.drawable.logo_leo,
            R.drawable.logo_virgo,
            R.drawable.logo_libra,
            R.drawable.logo_scorpio,
            R.drawable.logo_sagittarius,
            R.drawable.logo_capricorn,
            R.drawable.logo_aquarius,
            R.drawable.logo_pisces)
    }

    override fun generateModel(): Observable<List<MainViewZodiacModel>> {
        val names = generateNames()
        val images = generateImages()
        val array = ArrayList<MainViewZodiacModel>()

        for ( i in 0 until names.size) {
            array.add ( MainViewZodiacModel( names[i], images[i] ) )
        }

        return Observable.fromArray( array )
    }

}