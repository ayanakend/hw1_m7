package com.example.hw1_m7.domain.usecase

import com.example.hw1_m7.domain.repositories.NoteRepository
import javax.inject.Inject

class GetAllNoteUseCase @Inject constructor(private val noteRepository: NoteRepository){
    fun getAllNotes() = noteRepository.getAllNote()
}