@file:Suppress("MagicNumber")
package com.nameless.repository.mappers

import com.nameless.network.model.ForecastResponse
import com.nameless.repository.model.WeatherData
import com.nameless.repository.model.WeatherInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Convert a ForecastResponse into a weather data list in the form of
 * a Map where the key is an integer representing 0 as current day, increasing
 * by a value of 1 for every day into the future and a value which is a list
 * of WeatherData, broken down in 3-hour increments as per the api.
 */
private fun ForecastResponse.toWeatherDataList(): Map<Int, List<WeatherData>> {
    val minDay = list[0].dtText.parseDate().dayOfMonth
    return list.map { item ->
        val time = item.dtText
        val temperature = item.main.temp
        val windSpeed = item.wind.speed
        val pressure = item.main.pressure
        val humidity = item.main.humidity
        val icon = item.weather[0].icon // TODO: list of icons for 3hr period - just use first?
        val description = item.weather[0].description
        WeatherData(
            time = time.parseDate(),
            temp = 1.8f * (temperature - 273.15f) + 32f,
            pressure = pressure,
            windSpeed = windSpeed,
            humidity = humidity,
            icon = icon,
            description = description
        )
    }.groupBy {
        it.time.dayOfMonth - minDay
    }
}

/**
 * Parse the date from a string in the pattern of "yyyy-MM-dd HH:mm:ss".
 */
private fun String.parseDate() = LocalDateTime.parse(
    this,
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
)

/**
 * Convert a ForecastResponse to a WeatherInfo where days are mapped starting
 * with current day as 0 and increasing by a value of 1 for each day into the
 * future and a value as a list of WeatherData in 3-hour increments as per api.
 */
fun ForecastResponse.toWeatherInfo(): WeatherInfo {
    // The api seems to return 5 days from 'now' so there could be 6 days
    // so make the map mutable, remove any keys over 4 (0-based 5 day forecast)
    // and ensure it is an immutable map when returning the WeatherInfo object
    val weatherDataMap = this.toWeatherDataList().toMutableMap()
    if (weatherDataMap.count() > 5) weatherDataMap.entries.removeIf { it.key > 4 }
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataByDay = weatherDataMap.toMap(),
        currentWeatherData = currentWeatherData // TODO: would like to use this for larger card
    )
}