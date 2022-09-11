package com.nameless.room.model

/** WeatherData containing view-important information */
data class WeatherData(
    val time: String,
    val temp: Float,
    val pressure: Int,
    val windSpeed: Float,
    val humidity: Int,
    val icon: String,
    val description: String
)