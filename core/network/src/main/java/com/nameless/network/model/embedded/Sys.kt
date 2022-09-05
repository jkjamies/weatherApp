package com.nameless.network.model.embedded

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName("pod")
    val pod: String
)