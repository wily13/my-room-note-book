package com.example.myroomnotebook.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favorite_book")
data class Favorite (
    @PrimaryKey(autoGenerate = true)
    val idFavorite: Int,
    val titleBook: String,
    val author: String,
    val publisher: String,
    val year: Int
): Parcelable