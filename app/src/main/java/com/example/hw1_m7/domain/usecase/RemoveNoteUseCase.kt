package com.example.hw1_m7.domain.usecase

import com.example.hw1_m7.domain.model.Note
import com.example.hw1_m7.domain.repositories.NoteRepository

class RemoveNoteUseCase (
    private val noteRepository: NoteRepository
){

    fun removeNote(note: Note) = noteRepository.removeNote(note)
}