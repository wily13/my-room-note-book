package com.example.myroomnotebook.repository

import androidx.lifecycle.LiveData
import com.example.myroomnotebook.data.FavoriteDao
import com.example.myroomnotebook.model.Favorite

class FavoriteRepository(private val favoriteDao: FavoriteDao) {
    val getAllDataFavorite: LiveData<List<Favorite>> = favoriteDao.getAllDataFavorite()

    suspend fun insertFavorite(favorite: Favorite){
        favoriteDao.insertFavorite(favorite)
    }

    suspend fun updateFavorite(favorite: Favorite){
        favoriteDao.updateFavorite(favorite)
    }

    suspend fun deleteFavorite(favorite: Favorite){
        favoriteDao.deleteFavorite(favorite)
    }
}