package com.nameless.network

import com.nameless.network.model.ForecastResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

interface ApiService {

    suspend fun getWeatherForecast(lat: Float = 37.422131f, lon: Float = -122.084801f): ForecastResponse?

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



