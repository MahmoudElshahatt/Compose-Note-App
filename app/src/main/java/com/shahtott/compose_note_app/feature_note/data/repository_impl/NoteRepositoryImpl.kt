package com.shahtott.compose_note_app.feature_note.data.repository_impl

import com.shahtott.compose_note_app.feature_note.data.data_source.dao.NoteDao
import com.shahtott.compose_note_app.feature_note.data.mappers.toNote
import com.shahtott.compose_note_app.feature_note.data.mappers.toNoteEntity
import com.shahtott.compose_note_app.feature_note.domain.model.Note
import com.shahtott.compose_note_app.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes().map { it.map { it.toNote() } }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)?.toNote()
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

}