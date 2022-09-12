package com.nameless.mappers

import com.nameless.room.model.WeatherData
import com.nameless.room.model.WeatherInfo

// way too much work to do a full one, so just 2 days for this
val MOCKED_FIVE_DAY_FORECAST = WeatherInfo(
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
            time = "2022-09-14 18:00:00",
            temp = 80.96002f,
            pressure = 1018,
            windSpeed = 8.254162f,
            humidity = 33,
            icon = "02d",
            description = "few clouds"
        )
    )
)