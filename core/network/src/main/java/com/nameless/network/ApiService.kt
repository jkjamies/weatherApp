package com.nameless.network

import com.nameless.network.model.ForecastResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

interface ApiService {

    suspend fun getWeatherForecastFromCoordinates(lat: Double, lon: Double): ForecastResponse?
    suspend fun getWeatherForecastFromCityName(city: String): ForecastResponse?
    suspend fun getWeatherForecastFromZipCode(zip: String): ForecastResponse?

    companion object {
        fun build(): ApiService {
            return ApiServiceImpl(
                client = HttpClient(Android) {
                    install(Logging)
                    install(ContentNegotiation) {
                        json(Json {
                            prettyPrint = true
                            isLenient = true
                        })
                    }
                }
            )
        }
    }
}



