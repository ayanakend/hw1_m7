package com.example.hw1_m7.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw1_m7.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun noteDao():NoteDao
}