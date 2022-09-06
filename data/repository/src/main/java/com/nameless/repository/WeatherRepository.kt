package com.nameless.repository

import com.nameless.repository.model.HttpResponse
import com.nameless.repository.model.WeatherInfo

interface WeatherRepository {

    suspend fun getForecastData(lat: Double, lon: Double): HttpResponse<WeatherInfo>

}