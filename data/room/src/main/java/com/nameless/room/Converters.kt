package com.nameless.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nameless.room.model.WeatherData


class Converters {
    @TypeConverter
    fun toCityForecast(value: String): List<WeatherData> {
        val forecastType = object : TypeToken<List<WeatherData>>() {}.type
        return Gson().fromJson(value, forecastType)
    }

    @TypeConverter
    fun fromCityForecast(cityForecast: List<WeatherData>?): String {
        return Gson().toJson(cityForecast)
    }
}