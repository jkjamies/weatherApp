package com.nameless.weatherforecast.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.nameless.shared.WeatherTopAppBar
import com.nameless.weatherforecast.WeatherForecastViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherForecastScreen(
    navigateToDetails: (String?, Int) -> Unit
) {
    val viewModel = getViewModel<WeatherForecastViewModel>()

    Scaffold(
        topBar = { WeatherTopAppBar("5 Day Forecast") } // TODO: string resources
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = viewModel.state.isLoading),
                onRefresh = { viewModel.getWeatherData(viewModel.state.dailyWeatherData?.name) }
            ) {
                WeatherForecastList(
                    state = viewModel.state,
                    { viewModel.getWeatherData(it) },
                    { navigateToDetails(viewModel.state.dailyWeatherData?.name, it) }
                )
            }
        }
    }
}