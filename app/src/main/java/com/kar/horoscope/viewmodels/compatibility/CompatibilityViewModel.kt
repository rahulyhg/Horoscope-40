package com.kar.horoscope.viewmodels.compatibility

import android.arch.lifecycle.ViewModel
import com.kar.horoscope.service.CompatibilityService

class CompatibilityViewModel( private val compatibilityService: CompatibilityService) : ViewModel() {

    val getImageData = compatibilityService.getImages()
    val getNameData = compatibilityService.getNames()
}