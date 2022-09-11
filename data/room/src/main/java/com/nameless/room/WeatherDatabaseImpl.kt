package com.nameless.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nameless.room.model.WeatherInfo

@Database(entities = [WeatherInfo::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherDatabaseImpl : WeatherDatabase, RoomDatabase() {
    abstract override fun forecastDao(): ForecastDao
}
