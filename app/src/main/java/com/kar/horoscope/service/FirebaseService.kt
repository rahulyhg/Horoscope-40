package com.kar.horoscope.service

import com.kar.horoscope.models.DayModel
import io.reactivex.Observable

interface FirebaseService {
    fun read()
    fun getData() : Observable <DayModel>
}