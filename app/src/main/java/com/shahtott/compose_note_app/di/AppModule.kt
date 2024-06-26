package com.shahtott.compose_note_app.di

import android.app.Application
import androidx.room.Room
import com.shahtott.compose_note_app.feature_note.data.data_source.room.NoteDataBase
import com.shahtott.compose_note_app.feature_note.data.data_source.room.NoteDataBase.Companion.DATABASE_NAME
import com.shahtott.compose_note_app.feature_note.data.repository_impl.NoteRepositoryImpl
import com.shahtott.compose_note_app.feature_note.domain.repository.NoteRepository
import com.shahtott.compose_note_app.feature_note.domain.use_case.AddNoteUseCase
import com.shahtott.compose_note_app.feature_note.domain.use_case.DeleteNoteUseCase
import com.shahtott.compose_note_app.feature_note.domain.use_case.GetNoteUseCase
import com.shahtott.compose_note_app.feature_note.domain.use_case.GetNotesUseCase
import com.shahtott.compose_note_app.feature_note.domain.use_case.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataBase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dataBase: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(dataBase.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
    }
}