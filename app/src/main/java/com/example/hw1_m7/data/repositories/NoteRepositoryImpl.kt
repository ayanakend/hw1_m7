package com.example.hw1_m7.data.repositories

import com.example.hw1_m7.domain.repositories.NoteRepository
import com.example.hw1_m7.domain.utils.Resource
import com.example.hw1_m7.data.local.NoteDao
import com.example.hw1_m7.data.mappers.toEntity
import com.example.hw1_m7.data.mappers.toNote
import com.example.hw1_m7.domain.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override fun createNote(note: Note): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.createNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getAllNote(): Flow<Resource<List<Note>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.getAllNotes().map { it.toNote() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }
    }

    override fun editNote(note: Note): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.editNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun removeNote(note: Note): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.removeNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}