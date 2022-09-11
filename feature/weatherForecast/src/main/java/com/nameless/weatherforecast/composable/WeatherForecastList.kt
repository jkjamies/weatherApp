package com.nameless.weatherforecast.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nameless.shared.MissingWeatherData
import com.nameless.weatherforecast.WeatherForecastState

@Suppress("MagicNumber")
@Composable
fun WeatherForecastList(
    state: WeatherForecastState,
    navigateToDetails: (Int) -> Unit
) {
    state.dailyWeatherData?.let { data ->
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
    } ?: MissingWeatherData()
}