package com.example.myroomnotebook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myroomnotebook.data.NoteBookDatabase
import com.example.myroomnotebook.model.NoteBook
import com.example.myroomnotebook.repository.NoteBookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteBookViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<NoteBook>>
    private val repository: NoteBookRepository

    init {
        val noteBookDao = NoteBookDatabase.getDatabase(application).noteBookDao()
        repository = NoteBookRepository(noteBookDao)
        getAllData = repository.getAllData
    }

    fun insertBook(noteBook: NoteBook) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertBook(noteBook)
        }
    }

    fun updateBook(noteBook: NoteBook) {
        viewModelScope.launch {
            repository.updateBook(noteBook)
        }
    }

    fun deleteBook(noteBook: NoteBook) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBook(noteBook)
        }
    }
}