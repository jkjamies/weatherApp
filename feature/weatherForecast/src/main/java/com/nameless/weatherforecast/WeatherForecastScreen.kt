package com.nameless.weatherforecast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.androidx.compose.getViewModel

@Composable
fun WeatherForecastScreen() {
    val viewModel = getViewModel<WeatherForecastViewModel>()
    LaunchedEffect(Unit) {
        viewModel.getWeatherData()
    }

    WeatherForecastList(
        state = viewModel.state,
        onRefreshForecast = { viewModel.getWeatherData() }
    )
}