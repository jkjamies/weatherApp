package com.nameless.repository.mappers

import com.nameless.network.model.ForecastResponse
import com.nameless.repository.model.WeatherData
import com.nameless.repository.model.WeatherInfo
import timber.log.Timber
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun ForecastResponse.toWeatherDataList(): Map<Int, List<WeatherData>> {
    val minDay = list[0].dtText.parseDate().dayOfMonth
    return list.map { item ->
        val time = item.dtText
        val temperature = item.main.temp
        val windSpeed = item.wind.speed
        val pressure = item.main.pressure
        val humidity = item.main.humidity
        val icon = item.weather[0].icon // TODO: list of icons for 3hr period - just use first?
        WeatherData(
            time = time.parseDate(),
            tempCelsius = temperature,
            pressure = pressure,
            windSpeed = windSpeed,
            humidity = humidity,
            icon = icon
        )
    }.groupBy {
        it.time.dayOfMonth - minDay
    }
}

private fun String.parseDate() = LocalDateTime.parse(
    this,
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
)

fun ForecastResponse.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = this.toWeatherDataList()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataByDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}