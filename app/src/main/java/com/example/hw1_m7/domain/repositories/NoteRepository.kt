package com.example.hw1_m7.domain.repositories

import com.example.hw1_m7.domain.model.Note
import com.example.hw1_m7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun createNote(note: Note): Flow<Resource<Unit>>

    fun getAllNote(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun removeNote(note: Note): Flow<Resource<Unit>>
}