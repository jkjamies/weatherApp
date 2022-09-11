package com.nameless.weatherforecast

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nameless.mappers.toFiveDayForecast
import com.nameless.repository.WeatherRepository
import com.nameless.repository.model.HttpResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class WeatherForecastViewModel(private val repository: WeatherRepository) : ViewModel() {

    var state by mutableStateOf(WeatherForecastState())
        private set

    init {
        viewModelScope.launch {
            repository.getForecast().catch { error ->
                error.printStackTrace()
            }.collect {
                state = state.copy(
                    dailyWeatherData = it?.toFiveDayForecast(),
                    isLoading = false,
                    error = null
                )
            }
        }
    }

    fun getWeatherData() {
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
                        isLoading = false,
                        error = null
                    )
                }
                is HttpResponse.Error -> {
                    state = state.copy(
                        dailyWeatherData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}