package com.example.myroomnotebook.repository

import androidx.lifecycle.LiveData
import com.example.myroomnotebook.data.NoteBookDao
import com.example.myroomnotebook.model.NoteBook

class NoteBookRepository(private val noteBookDao: NoteBookDao) {

    val getAllData: LiveData<List<NoteBook>> = noteBookDao.getAllDataBook()

    suspend fun insertBook(noteBook: NoteBook){
        noteBookDao.insertBook(noteBook)
    }

    suspend fun updateBook(noteBook: NoteBook){
        noteBookDao.updateBook(noteBook)
    }

    suspend fun deleteBook(noteBook: NoteBook){
        noteBookDao.deleteBook(noteBook)
    }
}