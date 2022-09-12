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

        // We are only holding one forecast at a time and deleting all when we get a new one
        // to accommodate multiple forecasts we can use a query on delete and on the fetch
        // for the name of the city on the database model
        // This, however, gets complicated because we are accepting city name and zip code
        // so we would have to decipher city name from zip code to know how to properly query.
        // This would be something to consider coming back to if I get more time.
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