package com.kar.horoscope.service

import com.kar.horoscope.models.DayModel
import io.reactivex.Observable

interface FirebaseService {
    fun getData( date: String, titleZodiac: String ) : Observable <DayModel>
    fun pushDailyData( model : DayModel )
    fun getDate() : String
}