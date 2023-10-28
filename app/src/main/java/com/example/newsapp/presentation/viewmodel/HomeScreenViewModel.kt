package com.example.newsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.home.HomeScreenTO
import com.example.newsapp.domain.repository.NewsHeadlinesUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val newsHeadlinesUserCase: NewsHeadlinesUserCase) : ViewModel() {

    private val _newsHeadlinesMutableStateFlow = MutableStateFlow<HomeScreenTO>(HomeScreenTO.Loading)
    val newsHeadlinesStateFlow: StateFlow<HomeScreenTO>
        get() = _newsHeadlinesMutableStateFlow

    fun getNewsHeadLine(country: String) {
        viewModelScope.launch {
            val response = newsHeadlinesUserCase.invoke(country)
            if (response.isSuccessful && response.body() != null) {
                _newsHeadlinesMutableStateFlow.emit(HomeScreenTO.Success(response.body()!!))
            } else {
                _newsHeadlinesMutableStateFlow.emit(HomeScreenTO.Error)
            }
        }
    }
}