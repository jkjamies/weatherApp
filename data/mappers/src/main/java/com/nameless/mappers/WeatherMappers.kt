@file:Suppress("MagicNumber")

package com.nameless.mappers

import com.nameless.network.model.ForecastResponse
import com.nameless.room.model.WeatherData
import com.nameless.room.model.WeatherInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.abs

/**
 * Convert the KTor ForecastResponse data to a WeatherInfo object representing
 * the city and the flattened five day (or six depending on api) forecast.
 *
 * TODO: easily can add some rain, snow, wind speed and direction, etc to this object to show
 * on the daily detailed forecast screen. For now, keeping it very simple.
 */
fun ForecastResponse.toWeatherInfo(): WeatherInfo {
    val forecast = list.map { item ->
        val time = item.dtText
        val temperature = item.main.temp
        val windSpeed = item.wind.speed
        val pressure = item.main.pressure
        val humidity = item.main.humidity
        val icon = item.weather[0].icon // TODO: list of icons for 3hr period - just use first?
        val description = item.weather[0].description
        WeatherData(
            time = time,
            temp = 1.8f * (temperature - 273.15f) + 32f, // Kelvin to F
            pressure = pressure,
            windSpeed = windSpeed * 2.2369f, // m/s to mph
            humidity = humidity,
            icon = icon,
            description = description
        )
    }
    return WeatherInfo(
        id = city.id,
        name = city.name,
        sunrise = city.sunrise,
        sunset = city.sunset,
        forecast = forecast
    )
}

/**
 * Convert WeatherInfo object to a WeatherInfo with a list of all WeatherData representing a five
 * (or six, depending on the api) forecast. 3pm is used, else first provided if not available.
 */
fun WeatherInfo.toFiveDayForecast(): WeatherInfo {
    val minDay = this.forecast.first().time.parseDate().dayOfMonth
    val mappedData = this.forecast.map { it }.groupBy { it.time.parseDate().dayOfMonth - minDay }
    return WeatherInfo(
        id = this.id,
        name = this.name,
        sunrise = this.sunrise,
        sunset = this.sunset,
        forecast = mappedData.map { entry ->
            entry.value.find { abs(it.time.parseDate().hour.minus(15)) <= 2 } ?: entry.value[0]
        }
    )
}

/**
 * Convert WeatherInfo with flattened list of all forecast data to
 * WeatherInfo object with only list of forecast data for specific [dayId] which
 * corresponds to the current day (0) + days in future.
 */
fun WeatherInfo.toDailyForecast(dayId: Int): WeatherInfo {
    val minDay = this.forecast.first().time.parseDate().dayOfMonth
    val mappedData = this.forecast.map { it }.groupBy { it.time.parseDate().dayOfMonth - minDay }
    return WeatherInfo(
        id = this.id,
        name = this.name,
        sunrise = this.sunrise,
        sunset = this.sunset,
        forecast = mappedData[dayId] ?: listOf()
    )
}

/**
 * Parse the date from a string in the pattern of "yyyy-MM-dd HH:mm:ss".
 */
fun String.parseDate() = LocalDateTime.parse(
    this,
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
)
