package com.example.hw1_m7.presentation.ui.fragments.list_of_note

import com.example.hw1_m7.domain.model.Note
import com.example.hw1_m7.domain.usecase.GetAllNoteUseCase
import com.example.hw1_m7.domain.usecase.RemoveNoteUseCase
import com.example.hw1_m7.presentation.base.BaseViewModel
import com.example.hw1_m7.presentation.ui.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListOfNoteViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNoteUseCase,
    private val removeNoteUseCase: RemoveNoteUseCase
) : BaseViewModel() {
    private val _getAllNoteState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNoteState = _getAllNoteState.asStateFlow()

    private val _removeNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val removeNoteState = _removeNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNoteUseCase.getAllNotes().collectData(_getAllNoteState)
    }
    fun removeNote(note: Note) {
        removeNoteUseCase.removeNote(note).collectData(_removeNoteState)
    }
}