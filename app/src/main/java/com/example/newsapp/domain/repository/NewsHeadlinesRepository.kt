package com.example.newsapp.domain.repository

import com.example.newsapp.data.model.NewsResponse
import retrofit2.Response

interface NewsHeadlinesRepository {

    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}