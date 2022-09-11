package com.nameless.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nameless.room.model.WeatherInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface ForecastDao {
    @Query("SELECT * FROM city_weather_table")
    fun getForecast(): Flow<WeatherInfo?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(vararg forecast: WeatherInfo)

    @Query("DELETE FROM city_weather_table")
    suspend fun deleteForecast()
}