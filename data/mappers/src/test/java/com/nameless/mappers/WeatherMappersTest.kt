package com.nameless.mappers

import com.nameless.room.model.WeatherData
import com.nameless.room.model.WeatherInfo
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class WeatherMappersTest {

    @Test
    fun forecastResponseToWeatherInfo() {
        assertThat(MOCKED_FORECAST_RESPONSE.toWeatherInfo(), equalTo(MOCKED_WEATHER_INFO))
    }


    @Test
    fun forecastResponseToFiveDayForecast() {
        val weatherInfo = MOCKED_WEATHER_INFO.toFiveDayForecast()

        assertThat(
            weatherInfo, equalTo(
                WeatherInfo(
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
                        // second 2022-09-12 at 21:00:00 shouldn't be included
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
            )
        )
    }

    @Test
    fun forecastResponseToDailyForecast() {
        val weatherInfo = MOCKED_WEATHER_INFO.toDailyForecast(0)

        assertThat(
            weatherInfo, equalTo(
                WeatherInfo(
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
                        ),
                        // third 2022-09-14 at 18:00:00 not included (chose first day, 9/12)
                    )
                )
            )
        )
    }
}