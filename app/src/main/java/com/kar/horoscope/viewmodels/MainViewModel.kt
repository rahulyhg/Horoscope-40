package com.kar.horoscope.viewmodels

import android.arch.lifecycle.ViewModel
import com.kar.horoscope.service.MainService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(mainService: MainService ) : ViewModel() {

    val getObservableListModel =
        mainService
            .generateModel()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread() )!!

}