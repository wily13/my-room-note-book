package com.example.myroomnotebook.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myroomnotebook.model.Favorite

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insertFavorite(favorite: Favorite)

    @Update
    suspend fun updateFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorite_book ORDER BY titleBook DESC")
    fun getAllDataFavorite(): LiveData<List<Favorite>>
}