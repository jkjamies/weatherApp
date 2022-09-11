package com.nameless.weatherdetail.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.nameless.mappers.parseDate
import com.nameless.shared.WeatherTopAppBar
import com.nameless.weatherdetail.WeatherDetailViewModel
import org.koin.androidx.compose.getViewModel
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherDetailScreen(
    cityZip: String?,
    dayId: Int?,
    goBackToForecast: () -> Unit
) {
    val viewModel = getViewModel<WeatherDetailViewModel>()
    // This is starting the collection of flow
    // (because we want to know the dayId, so not using init block)
    LaunchedEffect(Unit) {
        viewModel.loadDailyForecast(dayId)
    }

    // TODO: using this in a few places, maybe a utility area to get the
    //  different permutations would be a good improvement in the future

    // TODO: string resources (non-translatable))
    val topBarTitle = "Weather Details for ${
        dayId?.let {
            viewModel.state.dailyForecast?.forecast?.get(it)?.time?.parseDate()
                ?.format(DateTimeFormatter.ofPattern("M/d/yy"))
        } ?: ""
    }"

    Scaffold(
        topBar = { WeatherTopAppBar(title = topBarTitle, navigationAction = goBackToForecast) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = viewModel.state.isLoading),
                onRefresh = { viewModel.getWeatherData(cityZip) }
            ) {
                WeatherDetailList(state = viewModel.state)
            }
        }
    }
}