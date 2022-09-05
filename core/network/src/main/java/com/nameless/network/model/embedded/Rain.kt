package com.nameless.network.model.embedded

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    @SerialName("3h")
    val lastThreeHours: Float
)