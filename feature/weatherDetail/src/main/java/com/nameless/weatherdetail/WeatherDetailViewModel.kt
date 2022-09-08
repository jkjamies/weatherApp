package com.nameless.weatherdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nameless.repository.WeatherRepository
import com.nameless.repository.model.HttpResponse
import kotlinx.coroutines.launch

class WeatherDetailViewModel(private val repository: WeatherRepository): ViewModel() {

    var state by mutableStateOf(WeatherDetailState())
        private set

    fun getWeatherData(dayIndex: Int?) {
        dayIndex?.let {
            viewModelScope.launch {
                // isLoading
                state = state.copy(
                    isLoading = true,
                    error = null
                )

                // call and return handling
                // TODO: get location and/or get zip code info
                when (val result = repository.getForecastData(37.422131, -122.084801)) {
                    is HttpResponse.Success -> {
                        state = state.copy(
                            weatherData = result.data?.weatherDataByDay?.get(it),
                            isLoading = false,
                            error = null
                        )
                    }
                    is HttpResponse.Error -> {
                        state = state.copy(
                            weatherData = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}