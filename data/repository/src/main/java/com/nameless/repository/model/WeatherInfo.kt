package com.nameless.repository.model

/** WeatherInfo containing all current and by-day weather information */
data class WeatherInfo(val weatherDataByDay: Map<Int, List<WeatherData>>)