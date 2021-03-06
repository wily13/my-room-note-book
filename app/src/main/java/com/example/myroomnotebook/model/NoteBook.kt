package com.example.myroomnotebook.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "note_book")
data class NoteBook (
    @PrimaryKey(autoGenerate = true)
    val idBook: Int,
    val title: String,
    @ColumnInfo(name = "description")
    val desc: String
): Parcelable