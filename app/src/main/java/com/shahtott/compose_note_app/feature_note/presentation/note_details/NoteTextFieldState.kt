package com.shahtott.compose_note_app.feature_note.presentation.note_details

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
