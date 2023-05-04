package com.example.hw1_m7.data.repositories

import com.example.hw1_m7.data.local.NoteDao
import com.example.hw1_m7.domain.model.Note
import com.example.hw1_m7.domain.repositories.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note)
    }

    fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }

    override fun editNote(note: Note) {
        return noteDao.editNote(note)
    }

    override fun removeNote(note: Note) {
        noteDao.removeNote(note)
    }

}