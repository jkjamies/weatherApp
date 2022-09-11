package com.nameless.repository

import com.nameless.mappers.toWeatherInfo
import com.nameless.network.ApiService
import com.nameless.repository.model.HttpResponse
import com.nameless.room.WeatherDatabase
import kotlinx.coroutines.flow.filterNotNull
import timber.log.Timber

/**
 * Data Repository to interface with [apiService] for Http network calls.
 */
@Suppress("TooGenericExceptionThrown", "TooGenericExceptionCaught")
class WeatherRepositoryImpl(
    private val weatherDatabase: WeatherDatabase,
    private val apiService: ApiService
) : WeatherRepository {

    /**
     * Get an HttpResponse of WeatherInfo as data from the apiService to represent
     * a 5-day forecast in the area given by the [cityZip] - deciphered by the function as either
     * a city name or zip code - from the user.
     */
    override suspend fun getForecastData(cityZip: String): HttpResponse {
        // simply just checking if the cityZip is numeric - if so using zip code else city name
        val response = cityZip.toIntOrNull()?.let {
            apiService.getWeatherForecastFromZipCode(cityZip)
        } ?: apiService.getWeatherForecastFromCityName(cityZip)

        if (response != null) {
            weatherDatabase.forecastDao().deleteForecast()
            weatherDatabase.forecastDao().insertForecast(response.toWeatherInfo())
        }

        return try {
            HttpResponse.Success()
        } catch (ex: Exception) {
            Timber.e(ex.message)
            HttpResponse.Error(ex.message ?: "Unknown Error")
        }
    }

    override suspend fun getForecast() = weatherDatabase.forecastDao().getForecast().filterNotNull()
}