package com.example.newsapp.presentation.navigation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.newsapp.presentation.navigation.NewsAppNavRoutes


fun NavGraphBuilder.HomeScreenNavigation(navController: NavController) {
    composable(
        route = NewsAppNavRoutes.HOME.route,
    ) {
        HomeScreenNavEntry(navController)
    }
}