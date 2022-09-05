package com.nameless.network

import com.nameless.network.model.ForecastResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import timber.log.Timber

class ApiServiceImpl(private val client: HttpClient) : ApiService {
    override suspend fun getWeatherForecast(lat: Float, lon: Float): ForecastResponse? {
        return try {
            val response = client.get {
                contentType(ContentType.Application.Json)
                url(ApiRoutes.FORECAST)
                parameter("lat", lat)
                parameter("lon", lon)
                parameter("appid", "your api key here")
            }
            Timber.d(response.bodyAsText())
            return response.body<ForecastResponse>()
        } catch (ex: Exception) {
            // TODO: maybe get fancier with 300, 400, 500, api-key errors
            Timber.e("Exception: ${ex.message}")
            null
        }
    }
}