package com.nameless.shared

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun MissingWeatherData() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0)), // need so accompanist swipe refresh pulls
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            text = "No Weather Forecast Data" // TODO: string resources
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MissingWeatherData()
}