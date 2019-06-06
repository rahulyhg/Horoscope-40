package com.kar.horoscope.viewmodels.forecast

import android.arch.lifecycle.ViewModel
import com.kar.horoscope.models.DayModel
import com.kar.horoscope.service.FirebaseService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ForecastViewModel( private val firebaseService: FirebaseService) : ViewModel() {

    fun getFirebaseData( titleZodiac: String ) : Observable<DayModel> {
        return firebaseService
            .getData(firebaseService.getDate(), titleZodiac )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread() )
    }
}