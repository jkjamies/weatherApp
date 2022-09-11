package com.nameless.weatherdetail

import com.nameless.room.model.WeatherInfo

data class WeatherDetailState(
    val dailyForecast: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)