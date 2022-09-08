package com.nameless.weatherdetail

import com.nameless.repository.model.WeatherData

data class WeatherDetailState(
    val weatherData: List<WeatherData>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)