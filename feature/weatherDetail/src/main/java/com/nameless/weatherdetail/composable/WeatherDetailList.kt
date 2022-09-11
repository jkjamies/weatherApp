package com.nameless.weatherdetail.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nameless.shared.MissingWeatherData
import com.nameless.weatherdetail.WeatherDetailState
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun WeatherDetailList(
    state: WeatherDetailState
) {
    state.dailyForecast?.forecast?.let { data ->
        if (data.isEmpty()) {
            MissingWeatherData()
        } else {
            Column {
                WeatherDetailHeader(state.dailyForecast.name)
                if (data.isEmpty()) {
                    MissingWeatherData()
                } else {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        items(items = data) { weatherData ->
                            WeatherDetailCard(weatherData = weatherData)
                        }
                    }
                }
            }
        }
    }
}