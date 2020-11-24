package com.example.myroomnotebook.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myroomnotebook.model.NoteBook

@Dao
interface NoteBookDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBook(noteBook: NoteBook)

    @Update
    suspend fun updateBook(noteBook: NoteBook)

    @Delete
    suspend fun deleteBook(noteBook: NoteBook)

    @Query("SELECT * FROM note_book ORDER BY idBook DESC")
    fun getAllDataBook(): LiveData<List<NoteBook>>
}