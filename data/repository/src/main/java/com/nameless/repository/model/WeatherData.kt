package com.nameless.repository.model

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temp: Float,
    val pressure: Int,
    val windSpeed: Float,
    val humidity: Int,
    val icon: String,
    val description: String
)