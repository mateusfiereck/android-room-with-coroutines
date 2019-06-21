package br.com.mateusfiereck.androidroomwithcoroutines.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.mateusfiereck.androidroomwithcoroutines.data.model.News

@Dao
interface NewsDao {

    @Insert
    suspend fun insert(news: News): Long

    @Query("SELECT * FROM news")
    suspend fun getAll(): List<News>

}