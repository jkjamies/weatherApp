package com.nameless.weatherforecast

import com.nameless.room.model.WeatherInfo

data class WeatherForecastState(
    val dailyWeatherData: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)