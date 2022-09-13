package com.nameless.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
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
    NavHost(navController)
}

@Composable
fun NavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "forecast"
    ) {
        composable("forecast") {
            WeatherForecastScreen { cityZip, dayId ->
                navController.navigate("detail/$cityZip/$dayId")
            }
        }
        composable(
            "detail/{cityZip}/{dayId}",
            arguments = listOf(
                navArgument("cityZip") { type = NavType.StringType },
                navArgument("dayId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            WeatherDetailScreen(
                backStackEntry.arguments?.getString("cityZip"),
                backStackEntry.arguments?.getInt("dayId")
            ) {
                navController.popBackStack()
            }
        }
    }
}

// TODO: could build an interface/entry point/better route structure to keep destinations/args