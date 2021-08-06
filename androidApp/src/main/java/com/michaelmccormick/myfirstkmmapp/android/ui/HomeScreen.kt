package com.michaelmccormick.myfirstkmmapp.android.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(navController = navController, startDestination = Route.SEARCH.route) {
            composable(Route.SEARCH.route) { SearchScreen() }
        }
    }
}

enum class Route(val route: String) {
    SEARCH("search"),
}
