package com.nameless.weatherforecast

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import kotlin.math.abs

@Composable
fun WeatherForecastList(
    state: WeatherForecastState,
) {
    state.weatherInfo?.weatherDataByDay?.map { entry ->
        // for daily weather, use the hour if within 2 hours of 3pm, else use first entry
        entry.value.find { abs(it.time.hour.minus(15)) <= 2 } ?: entry.value[0]
    }?.let { data ->
        LazyColumn(content = {
            items(data) { weatherData ->
                WeatherForecastCard(weatherData)
            }
        })
    }
}