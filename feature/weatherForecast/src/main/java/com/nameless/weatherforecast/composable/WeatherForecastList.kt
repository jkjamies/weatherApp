package com.nameless.weatherforecast.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameless.shared.MissingWeatherData
import com.nameless.weatherforecast.WeatherForecastState

@Suppress("MagicNumber")
@Composable
fun WeatherForecastList(
    state: WeatherForecastState,
    searchCityZipForecast: (String) -> Unit,
    navigateToDetails: (Int) -> Unit
) {
    Column {
        WeatherForecastHeader {
            searchCityZipForecast(it)
        }
        Text(
            text = "City: ${state.dailyWeatherData?.name ?: ""}",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        state.dailyWeatherData?.forecast?.let { data ->
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
}