package com.nameless.mappers

import com.nameless.room.model.WeatherData
import com.nameless.room.model.WeatherInfo

// assume first index chosen (minimum day)
val MOCK_DAILY_FORECAST = WeatherInfo(
    id = 4990729,
    name = "Detroit",
    sunrise = 1662980944,
    sunset = 1663026488,
    listOf(
        WeatherData(
            time = "2022-09-12 18:00:00",
            temp = 65.46199f,
            pressure = 1011,
            windSpeed = 12.213474f,
            humidity = 77,
            icon = "04d",
            description = "overcast clouds"
        ),
        WeatherData(
            time = "2022-09-12 21:00:00",
            temp = 67.35202f,
            pressure = 1010,
            windSpeed = 12.884545f,
            humidity = 64,
            icon = "04d",
            description = "broken clouds"
        )
    )
)