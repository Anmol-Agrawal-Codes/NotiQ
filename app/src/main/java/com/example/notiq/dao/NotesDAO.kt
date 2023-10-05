package com.example.notiq.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notiq.model.Notes

@Dao
interface NotesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("Select * from Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Query("Delete from Notes where id = :id")
    fun deleteNotes(id: Int)

    @Update
    fun updateNotes(notes: Notes)
}