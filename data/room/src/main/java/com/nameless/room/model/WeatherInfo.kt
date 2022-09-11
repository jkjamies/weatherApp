package com.nameless.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/** WeatherInfo containing all current and by-day weather information */
@Entity(tableName = "city_weather_table")
data class WeatherInfo(
    @PrimaryKey
    val id: Long,
    val name: String,
    val sunrise: Long,
    val sunset: Long,
    val forecast: List<WeatherData>
)