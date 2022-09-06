package com.nameless.weatherforecast

import com.nameless.repository.model.WeatherInfo

data class WeatherForecastState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)