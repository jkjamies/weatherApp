package com.nameless.room

import android.content.Context
import com.nameless.room.model.WeatherData
import com.nameless.room.model.WeatherInfo
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import androidx.room.Room
import kotlinx.coroutines.flow.first
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.flow.firstOrNull

class ForecastDaoTest {
    private lateinit var weatherDatabase: WeatherDatabase
    private lateinit var forecastDao: ForecastDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        weatherDatabase = Room.inMemoryDatabaseBuilder(context, WeatherDatabaseImpl::class.java)
            .allowMainThreadQueries().build()
        forecastDao = weatherDatabase.forecastDao()
    }

    @After
    fun teardown() {
        (weatherDatabase as WeatherDatabaseImpl).close()
    }

    @Test
    fun insertWeatherInfo_successfullyAdds() = runBlocking {
        val weatherInfo = WeatherInfo(
            id = 1,
            name = "test",
            sunrise = 1,
            sunset = 2,
            forecast = listOf(
                WeatherData(
                    time = "2022-09-14 18:00:00",
                    temp = 15.0f,
                    pressure = 1000,
                    windSpeed = 5.25f,
                    humidity = 65,
                    icon = "04d",
                    description = "clouds"
                )
            )
        )

        forecastDao.insertForecast(weatherInfo)
        assertThat(forecastDao.getForecast().first()?.name, equalTo("test"))
    }

    @Test
    fun insertWeatherInfo_successfullyDeletes() = runBlocking {
        val weatherInfo = WeatherInfo(
            id = 1,
            name = "test",
            sunrise = 1,
            sunset = 2,
            forecast = listOf(
                WeatherData(
                    time = "2022-09-14 18:00:00",
                    temp = 15.0f,
                    pressure = 1000,
                    windSpeed = 5.25f,
                    humidity = 65,
                    icon = "04d",
                    description = "clouds"
                )
            )
        )

        forecastDao.insertForecast(weatherInfo)
        assertThat(forecastDao.getForecast().first()?.name, equalTo("test"))
        forecastDao.deleteForecast()
        assertThat(forecastDao.getForecast().firstOrNull(), equalTo(null))
    }

}