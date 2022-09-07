package com.nameless.weatherforecast

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import timber.log.Timber
import kotlin.math.abs

@Composable
fun WeatherForecastList(
    state: WeatherForecastState,
    onRefreshForecast: () -> Unit
) {
    state.weatherInfo?.weatherDataByDay?.map { entry ->
        // for daily weather, use the hour if within 2 hours of 3pm, else use first entry
        entry.value.find { abs(it.time.hour.minus(15)) <= 2 } ?: entry.value[0]
    }?.let { data ->
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = state.isLoading),
            onRefresh = onRefreshForecast
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                itemsIndexed(items = data) { index, weatherData ->
                    WeatherForecastCard(index, weatherData) {
                        // TODO: navigate to detail view with it (index) as the key
                        Timber.d("clicked item $it")
                    }
                }
            }
        }
    }
}