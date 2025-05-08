package com.example.qrcodeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrcodeapp.data.HistoryDao
import com.example.qrcodeapp.data.HistoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QRViewModel @Inject constructor(private val historyDao: HistoryDao) : ViewModel() {
    val history: Flow<List<HistoryItem>> = historyDao.getAll()
    val favorites: Flow<List<HistoryItem>> = historyDao.getFavorites()

    fun saveScanResult(content: String) {
        viewModelScope.launch {
            historyDao.insert(HistoryItem(content = content, type = "scan", timestamp = System.currentTimeMillis()))
        }
    }

    fun saveGeneratedQR(content: String) {
        viewModelScope.launch {
            historyDao.insert(HistoryItem(content = content, type = "generate", timestamp = System.currentTimeMillis()))
        }
    }

    fun toggleFavorite(item: HistoryItem) {
        viewModelScope.launch {
            historyDao.updateFavorite(item.id, !item.isFavorite)
        }
    }

    fun deleteItem(item: HistoryItem) {
        viewModelScope.launch {
            historyDao.delete(item)
        }
    }
}
