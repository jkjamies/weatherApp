package com.nameless.repository

import com.nameless.network.ApiService
import com.nameless.repository.mappers.toWeatherInfo
import com.nameless.repository.model.HttpResponse
import com.nameless.repository.model.WeatherInfo
import timber.log.Timber

/**
 * Data Repository to interface with [apiService] for Http network calls.
 */
@Suppress("TooGenericExceptionThrown", "TooGenericExceptionCaught")
class WeatherRepositoryImpl(private val apiService: ApiService) : WeatherRepository {

    /**
     * Get an HttpResponse of WeatherInfo as data from the apiService to represent
     * a 5-day forecast in the area given by [lat] and [lon] from the user.
     */
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