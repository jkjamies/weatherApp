package com.nameless.weatherforecast.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.nameless.repository.model.WeatherData
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ImplicitDefaultLocale")
@Composable
fun WeatherForecastCard(
    dayIndex: Int,
    weatherData: WeatherData,
    onDayClick: (Int) -> Unit
) {
    Card(
        onClick = { onDayClick(dayIndex) },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(0.dp, 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    "https://openweathermap.org/img/wn/${weatherData.icon}.png"
                ),
                contentDescription = null,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    // using 12-hour format, could add a state for the unit (24 vs 12 hour formats)
                    text = weatherData.time.format(DateTimeFormatter.ofPattern("M/d - h:mm a")),
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Start),
                )
                Text(
                    // always F, could make state have unit
                    text = "${String.format("%.0f", weatherData.temp)}°F",
                    fontSize = 24.sp,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = weatherData.description,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterVertically),
            )
        }
    }
}
