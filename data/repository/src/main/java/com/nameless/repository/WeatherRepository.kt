package com.nameless.repository

import com.nameless.repository.model.HttpResponse
import com.nameless.room.model.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getForecastData(lat: Double, lon: Double): HttpResponse
    suspend fun getForecast(): Flow<WeatherInfo?>

}