package com.nameless.weatherforecast.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.nameless.shared.WeatherTopAppBar
import com.nameless.weatherforecast.WeatherForecastViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherForecastScreen(
    navigateToDetails: (Int) -> Unit
) {
    val viewModel = getViewModel<WeatherForecastViewModel>()
    LaunchedEffect(Unit) {
        viewModel.getWeatherData()
    }

    Scaffold(
        topBar = { WeatherTopAppBar("5 Day Forecast") } // TODO: string resources
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = viewModel.state.isLoading),
                onRefresh = { viewModel.getWeatherData() }
            ) {
                WeatherForecastList(state = viewModel.state, navigateToDetails)
            }
        }
    }
}