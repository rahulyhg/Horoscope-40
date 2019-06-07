package com.kar.horoscope.service

interface ShowService {
    fun generateFindArray() : Array<String>
    fun generateCompatibilityText(): Array<String>

}