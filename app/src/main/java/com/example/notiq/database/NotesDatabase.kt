package com.example.notiq.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notiq.dao.NotesDAO
import com.example.notiq.model.Notes

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun notesDao(): NotesDAO

    companion object{
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getNotesDatabase(context: Context): NotesDatabase{
            synchronized(this){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    NotesDatabase::class.java,"NotesDB")
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!

            }
        }
    }
}