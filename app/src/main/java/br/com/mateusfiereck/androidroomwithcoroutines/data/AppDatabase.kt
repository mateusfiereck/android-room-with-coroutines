package br.com.mateusfiereck.androidroomwithcoroutines.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.mateusfiereck.androidroomwithcoroutines.data.dao.NewsDao
import br.com.mateusfiereck.androidroomwithcoroutines.data.model.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        private lateinit var INSTANCE: AppDatabase

        fun build(context: Context): AppDatabase {
            synchronized(AppDatabase::class) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "news_database")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
