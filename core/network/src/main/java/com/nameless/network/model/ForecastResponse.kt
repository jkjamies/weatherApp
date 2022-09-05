package com.nameless.network.model

import com.nameless.network.model.embedded.City
import com.nameless.network.model.embedded.WeatherList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponse(
    @SerialName("cod")
    val cod: Int,
    @SerialName("message")
    val message: String,
    @SerialName("cnt")
    val cnt: Int,
    @SerialName("list")
    val list: List<WeatherList>,
    @SerialName("city")
    val city: City
)
