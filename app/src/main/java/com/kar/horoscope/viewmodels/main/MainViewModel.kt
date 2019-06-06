package com.kar.horoscope.viewmodels.main

import android.arch.lifecycle.ViewModel
import com.kar.horoscope.R
import com.kar.horoscope.service.MainService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(mainService: MainService ) : ViewModel() {

    val getObservableListModel =
        mainService
            .generateModel()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread() )!!

    private val service = mainService

    fun navigationLogic( id : Int ) {
        if ( id == R.id.write )     service.sendEmail()
        if ( id == R.id.feedback )  service.sendFeedback()
        if ( id == R.id.about )     service.goToAbout()
        if ( id == R.id.favourite ) service.goToSetDefault()
    }

}