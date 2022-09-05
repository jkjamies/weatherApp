package com.nameless.network.model.embedded

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherList(
    @SerialName("dt")
    val dt: Long,
    @SerialName("main")
    val main: Main,
    @SerialName("weather")
    val weather: List<Weather>,
    @SerialName("clouds")
    val clouds: Clouds,
    @SerialName("wind")
    val wind: Wind,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("pop")
    val pop: Float,
    @SerialName("rain")
    val rain: Rain? = null,
    @SerialName("snow")
    val snow: Snow? = null,
    @SerialName("sys")
    val sys: Sys,
    @SerialName("dt_txt")
    val dtText: String
)