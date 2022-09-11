package com.nameless.room

import android.app.Application
import androidx.room.Room
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nameless.room.model.WeatherData

interface WeatherDatabase {
    fun forecastDao(): ForecastDao

    companion object {
        fun build(application: Application): WeatherDatabase {
            return Room.databaseBuilder(
                application,
                WeatherDatabaseImpl::class.java,
                "weather-database"
            ).build()
        }
    }
}

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