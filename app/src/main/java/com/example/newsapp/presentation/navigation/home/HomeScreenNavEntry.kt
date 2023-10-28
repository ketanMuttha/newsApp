package com.example.newsapp.presentation.navigation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.presentation.ui.home.HomeScreen
import com.example.newsapp.presentation.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreenNavEntry(
    navController: NavController
){
   val homeScreenViewModel :HomeScreenViewModel = hiltViewModel()
   val homeScreenTO = homeScreenViewModel.newsHeadlinesStateFlow.collectAsState()
    homeScreenViewModel.getNewsHeadLine("us")
   HomeScreen(
       navController = navController,
       homeScreenTO = homeScreenTO.value)
}