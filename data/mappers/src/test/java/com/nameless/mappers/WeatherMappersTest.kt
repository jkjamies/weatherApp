package com.nameless.mappers

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
        assertThat(MOCKED_WEATHER_INFO.toFiveDayForecast(), equalTo(MOCKED_FIVE_DAY_FORECAST))
    }

    @Test
    fun forecastResponseToDailyForecast() {
        assertThat(MOCKED_WEATHER_INFO.toDailyForecast(0), equalTo(MOCK_DAILY_FORECAST))
    }
}
