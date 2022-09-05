package com.nameless.network.model.embedded

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snow(
    @SerialName("3h")
    val lastThreeHours: Float
)