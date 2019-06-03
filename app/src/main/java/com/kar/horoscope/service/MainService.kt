package com.kar.horoscope.service

import com.kar.horoscope.models.MainViewZodiacModel
import io.reactivex.Observable

interface MainService {
    fun generateNames() : List<String>
    fun generateImages() : List<Int>
    fun generateModel() : Observable<List<MainViewZodiacModel>>
}