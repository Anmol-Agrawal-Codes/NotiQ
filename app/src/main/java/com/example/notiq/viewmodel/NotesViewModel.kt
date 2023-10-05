package com.example.notiq.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notiq.database.NotesDatabase
import com.example.notiq.model.Notes
import com.example.notiq.repository.NotesRepository

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val dao = NotesDatabase.getNotesDatabase(application).notesDao()
    var repository = NotesRepository(dao)

    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }

    fun getNote(): LiveData<List<Notes>> = repository.getNotes()

    fun deleteNotes(id : Int){
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }
}