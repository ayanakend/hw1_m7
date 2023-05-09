package com.example.hw1_m7.data.mappers

import com.example.hw1_m7.data.model.NoteEntity
import com.example.hw1_m7.domain.model.Note

fun Note.toEntity() = NoteEntity(id, title, desc)

fun NoteEntity.toNote() = Note(id, title, desc)