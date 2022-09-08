package com.nameless.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nameless.weatherdetail.composable.WeatherDetailScreen
import com.nameless.weatherforecast.composable.WeatherForecastScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "forecast"
    ) {
        composable("forecast") {
            WeatherForecastScreen {
                navController.navigate("detail/$it")
            }
        }
        composable(
            "detail/{dayId}",
            arguments = listOf(navArgument("dayId") { type = NavType.IntType })
        ) { backStackEntry ->
            WeatherDetailScreen(backStackEntry.arguments?.getInt("dayId")) {
                navController.popBackStack()
            }
        }
    }
}

// TODO: could build an interface/entry point/better route structure to keep destinations/args