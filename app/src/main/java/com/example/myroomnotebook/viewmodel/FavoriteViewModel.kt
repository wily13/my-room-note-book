package com.example.myroomnotebook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myroomnotebook.data.FavoriteDatabase
import com.example.myroomnotebook.model.Favorite
import com.example.myroomnotebook.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application){
    val getAllDataFavorite: LiveData<List<Favorite>>
    val favoriteRepository: FavoriteRepository

    init {
        val favoriteDao = FavoriteDatabase.getDatabase(application).favoriteDao()
        favoriteRepository = FavoriteRepository(favoriteDao)
        getAllDataFavorite = favoriteRepository.getAllDataFavorite
    }

    fun insertFavorite(favorite: Favorite){
        viewModelScope.launch (Dispatchers.IO){
            favoriteRepository.insertFavorite(favorite)
        }
    }

    fun updateFavorite(favorite: Favorite){
        viewModelScope.launch (Dispatchers.IO) {
            favoriteRepository.updateFavorite(favorite)
        }
    }

    fun deleteFavorite(favorite: Favorite){
        viewModelScope.launch {
            favoriteRepository.deleteFavorite(favorite)
        }
    }

}