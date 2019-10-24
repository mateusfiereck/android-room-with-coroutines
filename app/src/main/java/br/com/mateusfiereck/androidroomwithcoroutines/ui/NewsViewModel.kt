package br.com.mateusfiereck.androidroomwithcoroutines.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mateusfiereck.androidroomwithcoroutines.data.model.News
import br.com.mateusfiereck.androidroomwithcoroutines.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    val news: LiveData<List<News>>
        get() = repository.news

    fun addNews(news: News) {
        viewModelScope.launch {
            repository.addNews(news)
        }
    }

    fun getNews() {
        viewModelScope.launch {
            repository.getNews()
        }
    }

}