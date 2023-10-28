package com.example.newsapp.data.api

import com.example.newsapp.constant.AppConstants
import com.example.newsapp.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(@Query("Country") country: String, @Query("apiKey") apiKey: String = AppConstants.API_KEY): Response<NewsResponse>
}