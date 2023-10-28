package com.example.newsapp.domain.repository

import com.example.newsapp.data.model.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsHeadlinesUserCase @Inject constructor(private val newsHeadlinesRepository: NewsHeadlinesRepository) {

    suspend operator fun invoke(country: String): Response<NewsResponse> {
        return  newsHeadlinesRepository.getNewsHeadline(country)
    }
}