package com.nameless.network

import com.nameless.network.model.ForecastResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import timber.log.Timber

@Suppress("TooGenericExceptionCaught")
class ApiServiceImpl(private val client: HttpClient) : ApiService {
    override suspend fun getWeatherForecast(lat: Double, lon: Double): ForecastResponse? {
        return try {
            val response = client.get {
                contentType(ContentType.Application.Json)
                url(ApiRoutes.getForecastRoute(lat, lon))
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