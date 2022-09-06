package com.nameless.repository.model

data class WeatherInfo(
    val weatherDataByDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)