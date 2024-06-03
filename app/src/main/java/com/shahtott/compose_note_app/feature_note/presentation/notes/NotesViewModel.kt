package com.shahtott.compose_note_app.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahtott.compose_note_app.feature_note.domain.use_case.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCase: NoteUseCase
) : ViewModel() {
    private val _notesState = mutableStateOf<NotesState>(NotesState())
    val notesState: State<NotesState> = _notesState

    val notes = notesUseCase.getNotesUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> {
               // notesUseCase.deleteNoteUseCase(event.note)
            }

            is NotesEvent.OrderNotes -> TODO()
            NotesEvent.RestoreNote -> TODO()
            NotesEvent.ToggleOrderSection -> TODO()
        }

    }
}


