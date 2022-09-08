package com.nameless.weatherdetail.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nameless.shared.MissingWeatherData
import com.nameless.weatherdetail.WeatherDetailState

@Composable
fun WeatherDetailList(
    state: WeatherDetailState
) {
    state.weatherData?.let { data ->
        if (data.isEmpty()) {
            MissingWeatherData()
        } else {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                itemsIndexed(items = data) { index, weatherData ->
                    WeatherDetailCard(dayIndex = index, weatherData = weatherData)
                }
            }
        }
    } ?: MissingWeatherData()
}