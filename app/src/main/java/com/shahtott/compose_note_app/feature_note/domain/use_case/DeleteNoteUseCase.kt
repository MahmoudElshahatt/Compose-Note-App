package com.shahtott.compose_note_app.feature_note.domain.use_case

import com.shahtott.compose_note_app.feature_note.domain.model.Note
import com.shahtott.compose_note_app.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}