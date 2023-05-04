package com.example.hw1_m7.domain.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hw1_m7.domain.model.Note

interface NoteRepository {

    fun createNote(noteEntity: Note)

    fun getAllNote(): List<Note>

    fun editNote(noteEntity: Note)

    fun removeNote(noteEntity: Note)

}