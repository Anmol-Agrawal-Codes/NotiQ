package com.example.notiq.repository

import androidx.lifecycle.LiveData
import com.example.notiq.dao.NotesDAO
import com.example.notiq.model.Notes

class NotesRepository(val notesDao: NotesDAO) {

    fun getNotes(): LiveData<List<Notes>>{
        return notesDao.getNotes()
    }

    fun insertNotes(notes: Notes){
        notesDao.insertNotes(notes)
    }

    fun deleteNotes(id: Int){
        notesDao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        notesDao.updateNotes(notes)
    }

}