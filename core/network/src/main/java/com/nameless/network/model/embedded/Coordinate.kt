package com.nameless.network.model.embedded

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinate(
    @SerialName("lat")
    val lat: Float,
    @SerialName("lon")
    val lon: Float
)