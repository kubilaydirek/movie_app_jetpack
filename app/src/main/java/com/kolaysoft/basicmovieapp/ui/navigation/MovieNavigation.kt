package com.kolaysoft.basicmovieapp.ui.navigation

import DetailScreen
import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(MovieScreens.DetailScreen.name + "/{movieId}", arguments = listOf(navArgument("movieId") {
            type = NavType.StringType
        })) {
            DetailScreen(navController = navController, movieId = it.arguments?.getString("movieId"))
        }
    }
}