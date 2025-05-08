package com.example.qrcodeapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val type: String,
    val timestamp: Long,
    val isFavorite: Boolean = false
)
