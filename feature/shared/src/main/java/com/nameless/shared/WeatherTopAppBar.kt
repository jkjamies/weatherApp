package com.nameless.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar(title: String, navigationAction: (() -> Unit)? = null,) {
    SmallTopAppBar(
        title = { Text(title) }, // TODO: string resources
        navigationIcon = {
            navigationAction?.let {
                IconButton(onClick = it) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Go back to Forecast"
                    )
                }
            }
        }
    )
}