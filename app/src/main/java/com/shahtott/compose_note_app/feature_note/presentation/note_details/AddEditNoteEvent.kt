package com.shahtott.compose_note_app.feature_note.presentation.note_details

import androidx.compose.ui.focus.FocusState


sealed interface AddEditNoteEvent {
    data class OnTitleChanged(val value: String) : AddEditNoteEvent
    data class OnChangeTitleFocus(val focusState: FocusState) : AddEditNoteEvent
    data class OnContentChanged(val value: String) : AddEditNoteEvent
    data class OnChangeContentFocus(val focusState: FocusState) : AddEditNoteEvent
    data class OnChangeColor(val color: Int) : AddEditNoteEvent
    object OnSaveNote : AddEditNoteEvent
}
