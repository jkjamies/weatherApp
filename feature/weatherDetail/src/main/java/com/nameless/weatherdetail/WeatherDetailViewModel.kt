package com.nameless.weatherdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nameless.mappers.toDailyForecast
import com.nameless.repository.WeatherRepository
import com.nameless.repository.model.HttpResponse
import kotlinx.coroutines.launch

class WeatherDetailViewModel(private val repository: WeatherRepository) : ViewModel() {

    var state by mutableStateOf(WeatherDetailState())
        private set

    fun loadDailyForecast(dayIndex: Int?) {
        dayIndex?.let {
            viewModelScope.launch {
                repository.getForecast().collect { weatherInfo ->
                    weatherInfo?.let {
                        state = state.copy(
                            dailyForecast = it.toDailyForecast(dayIndex),
                            isLoading = false,
                            error = null
                        )
                    }
                }
            }
        }
    }

    fun getWeatherData(cityZip: String?) {
        cityZip?.let {
            viewModelScope.launch {
                // isLoading
                state = state.copy(
                    isLoading = true,
                    error = null
                )

                // call and return handling
                // TODO: get location and/or get zip code info
                state = when (val result = repository.getForecastData(it)) {
                    is HttpResponse.Success -> {
                        state.copy(
                            isLoading = false,
                            error = null
                        )
                    }
                    is HttpResponse.Error -> {
                        state.copy(
                            dailyForecast = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}