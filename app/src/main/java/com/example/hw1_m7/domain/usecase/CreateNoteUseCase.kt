package com.example.hw1_m7.domain.usecase

import com.example.hw1_m7.domain.model.Note
import com.example.hw1_m7.domain.repositories.NoteRepository

class CreateNoteUseCase(private val noteRepository: NoteRepository) {
    fun createNote(note: Note) = noteRepository.createNote(note)
}