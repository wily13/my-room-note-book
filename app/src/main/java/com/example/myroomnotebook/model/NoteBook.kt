package com.example.myroomnotebook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_book")
data class NoteBook (
    @PrimaryKey(autoGenerate = true)
    val idBook: Int,
    val title: String,
    @ColumnInfo(name = "description")
    val desc: String
)