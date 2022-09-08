package com.nameless.weatherdetail

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherDetailModule = module {
    viewModel { WeatherDetailViewModel(get()) }
}