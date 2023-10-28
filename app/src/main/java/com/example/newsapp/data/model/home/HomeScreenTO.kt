package com.example.newsapp.data.model.home

import com.example.newsapp.data.model.NewsResponse

sealed class HomeScreenTO {

    object Loading: HomeScreenTO()

    data class Success(val data : NewsResponse): HomeScreenTO()

    object Error: HomeScreenTO()
}
