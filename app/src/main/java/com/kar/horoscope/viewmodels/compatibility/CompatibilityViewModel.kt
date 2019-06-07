package com.kar.horoscope.viewmodels.compatibility

import android.arch.lifecycle.ViewModel
import com.kar.horoscope.service.CompatibilityService

class CompatibilityViewModel( compatibilityService: CompatibilityService) : ViewModel() {

    val getImageData = compatibilityService.getImages()
    val getNameData = compatibilityService.getNames()
}