package com.shahtott.compose_note_app.feature_note.domain.use_case

import com.shahtott.compose_note_app.feature_note.domain.model.Note
import com.shahtott.compose_note_app.feature_note.domain.repository.NoteRepository
import com.shahtott.compose_note_app.feature_note.domain.util.InvalidNoteException
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException.InvalidTitleNoteException()
        } else if (note.content.isBlank()) {
            throw InvalidNoteException.InvalidContentNoteException()
        } else {
            noteRepository.insertNote(note)
        }
    }
}