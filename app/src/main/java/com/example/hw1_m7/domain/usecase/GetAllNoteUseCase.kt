package com.example.hw1_m7.domain.usecase

import com.example.hw1_m7.domain.repositories.NoteRepository

class GetAllNoteUseCase (
    private val noteRepository: NoteRepository
){
    fun getAllNotes() = noteRepository.getAllNote()
}