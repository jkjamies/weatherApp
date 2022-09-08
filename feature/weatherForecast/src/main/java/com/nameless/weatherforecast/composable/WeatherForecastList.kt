package com.nameless.weatherforecast.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nameless.shared.MissingWeatherData
import com.nameless.weatherforecast.WeatherForecastState
import kotlin.math.abs

@Suppress("MagicNumber")
@Composable
fun WeatherForecastList(
    state: WeatherForecastState,
    navigateToDetails: (Int) -> Unit
) {
    state.weatherInfo?.weatherDataByDay?.map { entry ->
        // for daily weather, use the hour if within 2 hours of 3pm, else use first entry
        entry.value.find { abs(it.time.hour.minus(15)) <= 2 } ?: entry.value[0]
    }?.let { data ->
        if (data.isEmpty()) {
            MissingWeatherData()
        } else {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                itemsIndexed(items = data) { index, weatherData ->
                    WeatherForecastCard(
                        dayIndex = index,
                        weatherData = weatherData,
                        onDayClick = navigateToDetails
                    )
                }
            }
        }
    } ?: MissingWeatherData()
}