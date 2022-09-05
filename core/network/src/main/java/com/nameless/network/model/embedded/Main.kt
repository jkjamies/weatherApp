package com.nameless.network.model.embedded

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerialName("temp")
    val temp: Float,
    @SerialName("feels_like")
    val feelsLike: Float,
    @SerialName("temp_min")
    val tempMin: Float,
    @SerialName("temp_max")
    val tempMax: Float,
    @SerialName("pressure")
    val pressure: Int,
    @SerialName("sea_level")
    val seaLevel: Int,
    @SerialName("grnd_level")
    val grndLevel: Int,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("temp_kf")
    val tempKf: Float
)