package br.com.mateusfiereck.androidroomwithcoroutines.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.mateusfiereck.androidroomwithcoroutines.data.dao.NewsDao
import br.com.mateusfiereck.androidroomwithcoroutines.data.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class NewsRepository(private val newsDao: NewsDao) {

    val news: MutableLiveData<List<News>> = MutableLiveData()

    suspend fun addNews(news: News) {
        withContext(Dispatchers.IO) {
            newsDao.insert(news)
        }
    }

    suspend fun getNews() {
        withContext(Dispatchers.IO) {
            Timber.d("getNews: withContext(Dispatchers.IO)")
            news.postValue(newsDao.getAll())
        }
    }
}