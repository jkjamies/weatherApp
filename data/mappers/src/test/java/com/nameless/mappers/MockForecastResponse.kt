package com.nameless.mappers

import com.nameless.network.model.ForecastResponse
import com.nameless.network.model.embedded.City
import com.nameless.network.model.embedded.Clouds
import com.nameless.network.model.embedded.Coordinate
import com.nameless.network.model.embedded.Main
import com.nameless.network.model.embedded.Sys
import com.nameless.network.model.embedded.Weather
import com.nameless.network.model.embedded.WeatherList
import com.nameless.network.model.embedded.Wind

val MOCKED_FORECAST_RESPONSE = ForecastResponse(
    cod = 200,
    message = "0",
    cnt = 40,
    list = listOf(
        WeatherList(
            dt = 1663005600,
            main = Main(
                temp = 291.74f,
                feelsLike = 291.67f,
                tempMin = 291.74f,
                tempMax = 294.65f,
                pressure = 1011,
                seaLevel = 1011,
                grndLevel = 988,
                humidity = 77,
                tempKf = -2.91f
            ),
            weather = listOf(
                Weather(
                    id = 804,
                    main = "Clouds",
                    description = "overcast clouds",
                    icon = "04d"
                )
            ),
            clouds = Clouds(
                all = 100
            ),
            wind = Wind(
                speed = 5.46f,
                deg = 217,
                gust = 6.12f
            ),
            visibility = 10000,
            pop = 0.0f,
            rain = null,
            snow = null,
            sys = Sys(
                pod = "d"
            ),
            dtText = "2022-09-12 18:00:00"
        ),
        WeatherList(
            dt = 1663016400,
            main = Main(
                temp = 292.79f,
                feelsLike = 292.48f,
                tempMin = 292.79f,
                tempMax = 294.89f,
                pressure = 1010,
                seaLevel = 1010,
                grndLevel = 987,
                humidity = 64,
                tempKf = -2.1f
            ),
            weather = listOf(
                Weather(
                    id = 803,
                    main = "Clouds",
                    description = "broken clouds",
                    icon = "04d"
                )
            ),
            clouds = Clouds(
                all = 83
            ),
            wind = Wind(
                speed = 5.76f,
                deg = 225,
                gust = 7.11f
            ),
            visibility = 10000,
            pop = 0.0f,
            rain = null,
            snow = null,
            sys = Sys(
                pod = "d"
            ),
            dtText = "2022-09-12 21:00:00"
        ),
        WeatherList(
            dt = 1663178400,
            main = Main(
                temp = 300.35f,
                feelsLike = 299.82f,
                tempMin = 300.35f,
                tempMax = 300.35f,
                pressure = 1018,
                seaLevel = 1018,
                grndLevel = 997,
                humidity = 33,
                tempKf = 0.0f
            ),
            weather = listOf(
                Weather(
                    id = 801,
                    main = "Clouds",
                    description = "few clouds",
                    icon = "02d"
                )
            ),
            clouds = Clouds(
                all = 17
            ),
            wind = Wind(
                speed = 3.69f,
                deg = 286,
                gust = 5.12f
            ),
            visibility = 10000,
            pop = 0.0f,
            rain = null,
            snow = null,
            sys = Sys(
                pod = "d"
            ),
            dtText = "2022-09-14 18:00:00"
        ),
    ),
    city = City(
        id = 4990729,
        name = "Detroit",
        coord = Coordinate(
            lat = 42.3314f,
            lon = -83.0458f
        ),
        country = "US",
        population = 713777,
        timezone = -14400,
        sunrise = 1662980944,
        sunset = 1663026488
    )
)
