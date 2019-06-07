package com.kar.horoscope.viewmodels.showcompatibility

import android.arch.lifecycle.ViewModel
import com.kar.horoscope.service.ShowService

class ShowCompatibilityViewModel(private val showService: ShowService) : ViewModel() {

    fun getText( finder: String ) : String {
        val size = showService.generateFindArray().size
        val array = showService.generateFindArray()
        val textArray = showService.generateCompatibilityText()
        var id = -1

        for( i in 0 until array.size) {
            if ( finder == array[i] ) {
                id = i
                break
            }
        }

        return textArray[id]
    }
}