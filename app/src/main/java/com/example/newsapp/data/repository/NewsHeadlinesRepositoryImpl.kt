package com.example.newsapp.data.repository

import com.example.newsapp.data.api.RetrofitApiService
import com.example.newsapp.data.model.NewsResponse
import com.example.newsapp.domain.repository.NewsHeadlinesRepository
import retrofit2.Response
import javax.inject.Inject

class NewsHeadlinesRepositoryImpl @Inject constructor(private val retrofitApiService: RetrofitApiService) : NewsHeadlinesRepository {

    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
      return retrofitApiService.getNewsHeadline(country)
    }
}