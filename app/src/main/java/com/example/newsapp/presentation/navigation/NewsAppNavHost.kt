package com.example.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.navigation.home.HomeScreenNavigation

@Composable
fun NewsAppNavHost(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NewsAppNavRoutes.HOME.route) {
      HomeScreenNavigation(navController)
    }
}