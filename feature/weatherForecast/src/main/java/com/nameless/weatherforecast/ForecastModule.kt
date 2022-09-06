package com.nameless.weatherforecast

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val forecastModule = module {
    viewModel { WeatherForecastViewModel(get()) }
}