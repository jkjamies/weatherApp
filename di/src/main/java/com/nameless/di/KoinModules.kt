package com.nameless.di

import com.nameless.network.ApiService
import com.nameless.repository.WeatherRepository
import com.nameless.repository.WeatherRepositoryImpl
import com.nameless.room.WeatherDatabase
import com.nameless.weatherdetail.WeatherDetailViewModel
import com.nameless.weatherforecast.WeatherForecastViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val networkModule = module {
    single<ApiService> { ApiService.build() }
}

private val roomModule = module {
    single<WeatherDatabase> { WeatherDatabase.build(androidApplication()) }
}

private val repositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
}

private val viewModelsModule = module {
    viewModel { WeatherForecastViewModel(get()) }
    viewModel { WeatherDetailViewModel(get()) }
}

val koinModules = listOf(
    networkModule,
    roomModule,
    repositoryModule,
    viewModelsModule
)