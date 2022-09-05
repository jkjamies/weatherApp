package com.nameless.network.model.embedded

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    @SerialName("speed")
    val speed: Float,
    @SerialName("deg")
    val deg: Int,
    @SerialName("gust")
    val gust: Float
)