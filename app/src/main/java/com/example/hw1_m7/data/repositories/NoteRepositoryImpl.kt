package com.example.hw1_m7.data.repositories

import com.example.hw1_m7.data.base.BaseRepository
import com.example.hw1_m7.data.local.NoteDao
import com.example.hw1_m7.data.mappers.toEntity
import com.example.hw1_m7.data.mappers.toNote
import com.example.hw1_m7.domain.model.Note
import com.example.hw1_m7.domain.repositories.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : BaseRepository(), NoteRepository {
    override fun createNote(note: Note) = doRequest{
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNote() = doRequest{
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doRequest{
        noteDao.editNote(note.toEntity())
    }

    override fun removeNote(note: Note)= doRequest{
        noteDao.removeNote(note.toEntity())
    }
}