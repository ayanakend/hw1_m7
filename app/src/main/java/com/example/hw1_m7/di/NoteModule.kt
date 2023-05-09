package com.example.hw1_m7.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import android.content.Context
import androidx.room.Room
import com.example.hw1_m7.data.local.NoteDao
import com.example.hw1_m7.data.local.NoteDataBase
import com.example.hw1_m7.data.repositories.NoteRepositoryImpl
import com.example.hw1_m7.domain.repositories.NoteRepository

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "note_db"
    )

    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) = noteDataBase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}