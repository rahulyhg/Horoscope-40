package com.kar.horoscope.service

import com.kar.horoscope.models.DayModel
import io.reactivex.Observable

interface FirebaseService {
    fun getData( date: String, titleZodiac: String, path: String ) : Observable <DayModel>
    fun pushDailyData( model : DayModel )
    fun getToday() : String
    fun getYesterday() : String
    fun getTomorrow() : String
    fun getMonth() : String
}