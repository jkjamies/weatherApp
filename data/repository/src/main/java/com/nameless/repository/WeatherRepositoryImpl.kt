package com.nameless.repository

import com.nameless.network.ApiService
import com.nameless.repository.mappers.toWeatherInfo
import com.nameless.repository.model.HttpResponse
import com.nameless.repository.model.WeatherInfo
import timber.log.Timber

class WeatherRepositoryImpl(private val apiService: ApiService) : WeatherRepository {

    override suspend fun getForecastData(lat: Double, lon: Double): HttpResponse<WeatherInfo> {
        return try {
            HttpResponse.Success(
                data = apiService.getWeatherForecast(
                    lat = lat,
                    lon = lon
                )?.toWeatherInfo() ?: throw Exception("Api returned empty or null response")
            )
        } catch (ex: Exception) {
            Timber.e(ex.message)
            HttpResponse.Error(ex.message ?: "Unknown Error")
        }
    }
}