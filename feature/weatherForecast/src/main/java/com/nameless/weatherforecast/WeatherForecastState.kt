package com.nameless.weatherforecast

import com.nameless.room.model.WeatherData


data class WeatherForecastState(
    val dailyWeatherData: List<WeatherData>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)