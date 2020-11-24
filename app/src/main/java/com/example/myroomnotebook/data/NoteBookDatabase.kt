package com.example.myroomnotebook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myroomnotebook.model.NoteBook

@Database(entities = [NoteBook::class], version = 1)
abstract class NoteBookDatabase: RoomDatabase() {

    abstract fun noteBookDao(): NoteBookDao

    companion object {
        @Volatile
        private var INSTANCE : NoteBookDatabase? = null

        fun getDatabase(context: Context): NoteBookDatabase {
            return INSTANCE ?:
                    synchronized(this){
                        val instance = Room.databaseBuilder(
                            context.applicationContext,
                            NoteBookDatabase::class.java,
                            "notebook_db"
                        ).build()
                        INSTANCE = instance
                        instance
                    }
        }
    }
}