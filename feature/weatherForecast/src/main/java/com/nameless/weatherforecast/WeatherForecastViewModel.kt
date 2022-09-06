package com.nameless.weatherforecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nameless.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherForecastViewModel(private val repository: WeatherRepository): ViewModel() {
    fun getWeatherData() {
        viewModelScope.launch {
            repository.getForecastData(37.422131, -122.084801)
        }
    }
}