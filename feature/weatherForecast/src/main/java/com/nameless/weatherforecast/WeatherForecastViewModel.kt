package com.nameless.weatherforecast

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nameless.repository.WeatherRepository
import com.nameless.repository.model.HttpResponse
import kotlinx.coroutines.launch

class WeatherForecastViewModel(private val repository: WeatherRepository): ViewModel() {

    var state by mutableStateOf(WeatherForecastState())
        private set

    fun getWeatherData() {
        viewModelScope.launch {
            // isLoading
            state = state.copy(
                weatherInfo = null, // TODO: might not need this, should pull from cache on load
                isLoading = true,
                error = null
            )

            // call and return handling
            // TODO: get location and/or get zip code info
            when (val result = repository.getForecastData(37.422131, -122.084801)) {
                is HttpResponse.Success -> {
                    state = state.copy(
                        weatherInfo = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is HttpResponse.Error -> {
                    state = state.copy(
                        weatherInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}