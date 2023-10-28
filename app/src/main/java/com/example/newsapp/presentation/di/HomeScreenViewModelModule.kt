package com.example.newsapp.presentation.di

import com.example.newsapp.data.api.RetrofitApiService
import com.example.newsapp.data.repository.NewsHeadlinesRepositoryImpl
import com.example.newsapp.domain.repository.NewsHeadlinesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HomeScreenViewModelModule {

    @Provides
    fun providesNewsHeadlinesRepositoryImpl(retrofitApiService: RetrofitApiService): NewsHeadlinesRepository {
        return NewsHeadlinesRepositoryImpl(retrofitApiService)
    }
}