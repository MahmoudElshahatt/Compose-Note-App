package com.shahtott.compose_note_app.feature_note.presentation.note_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.shahtott.compose_note_app.feature_note.domain.model.Note
import com.shahtott.compose_note_app.feature_note.presentation.notes.NotesViewModel
import javax.inject.Inject

class AddEditNoteViewModel @Inject constructor(
    private val notesViewModel: NotesViewModel
) : ViewModel() {
    private val _noteTitle = mutableStateOf(NoteTextFieldState())
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState())
    val noteContent: State<NoteTextFieldState> = _noteContent

    private val _noteColor = mutableStateOf(Note.noteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor


}