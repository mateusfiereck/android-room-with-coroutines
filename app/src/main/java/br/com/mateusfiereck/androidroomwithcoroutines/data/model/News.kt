package br.com.mateusfiereck.androidroomwithcoroutines.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class News(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val title: String,
    val text: String
)