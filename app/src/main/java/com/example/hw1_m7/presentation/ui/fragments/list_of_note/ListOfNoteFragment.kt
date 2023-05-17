package com.example.hw1_m7.presentation.ui.fragments.list_of_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw1_m7.R
import com.example.hw1_m7.databinding.FragmentListOfNoteBinding
import com.example.hw1_m7.domain.model.Note
import com.example.hw1_m7.presentation.base.BaseFragment
import com.example.hw1_m7.presentation.ui.fragments.list_of_note.adapter.ListOfNoteAdapter
import com.example.hw1_m7.presentation.ui.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfNoteFragment : BaseFragment() {
    private lateinit var binding: FragmentListOfNoteBinding
    private val viewModel by viewModels<ListOfNoteViewModel>()
    private lateinit var adapter: ListOfNoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfNoteBinding.inflate(inflater, container, false)
        return binding.root
        adapter = ListOfNoteAdapter(this::removeNote, this::editClick)
        binding.noteRv.adapter = adapter
    }



    override fun initClickers() {
        binding.addFab.setOnClickListener {
            findNavController().navigate(R.id.createEditFragment)
        }
    }

    fun editClick(note: Note, id: Int){
        findNavController().navigate(R.id.createEditFragment, bundleOf(
            "note" to note,
            "id" to id
        ))
    }

    override fun loadView() {
        viewModel.getAllNotes()
        viewModel.getAllNoteState.collectState(state = {state->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            adapter.addNotes(data)
        })
    }

    private fun removeNote(note: Note, id: Int) {
        viewModel.removeNote(note)
        viewModel.removeNoteState.collectState(state = {state->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            loadView()
        })
    }
}