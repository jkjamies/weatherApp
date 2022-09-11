package com.nameless.weatherdetail.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherDetailHeader(city: String, sunrise: String, sunset: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            // using 12-hour format, could add a state for the unit (24 vs 12 hour formats)
            text = "City: $city",
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
        )
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                // using 12-hour format, could add a state for the unit (24 vs 12 hour formats)
                text = "Sunrise: $sunrise",
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
            )
            Text(
                // using 12-hour format, could add a state for the unit (24 vs 12 hour formats)
                text = "Sunset: $sunset",
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
            )
        }
    }
}