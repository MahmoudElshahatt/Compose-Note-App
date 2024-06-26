package com.shahtott.compose_note_app.feature_note.presentation.notes


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shahtott.compose_note_app.R
import com.shahtott.compose_note_app.feature_note.domain.model.Note
import com.shahtott.compose_note_app.feature_note.domain.util.NoteOrder
import com.shahtott.compose_note_app.feature_note.presentation.notes.components.NoteItem
import com.shahtott.compose_note_app.feature_note.presentation.notes.components.OrderSection
import com.shahtott.compose_note_app.ui.theme.ComposeNoteappTheme
import kotlinx.coroutines.launch

@Composable
fun NotesScreen(
    navController: NavController,
    notesViewModel: NotesViewModel = hiltViewModel()
) {
    NotesContent(
        state = notesViewModel.notesState.value,
        onAddEditNoteClicked = {},
        onSortClicked = {
            notesViewModel.onEvent(NotesEvent.ToggleOrderSection)
        },
        onOrderChanged = { noteOrder ->
            notesViewModel.onEvent(NotesEvent.OrderNotes(noteOrder))
        },
        onDeleteNote = { note ->
            notesViewModel.onEvent(NotesEvent.DeleteNote(note))
        },
        onRestoreNote = {
            notesViewModel.onEvent(NotesEvent.RestoreNote)
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotesContent(
    state: NotesState,
    onAddEditNoteClicked: () -> Unit,
    onSortClicked: () -> Unit,
    onOrderChanged: (NoteOrder) -> Unit,
    onDeleteNote: (Note) -> Unit,
    onRestoreNote: () -> Unit
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddEditNoteClicked,
                containerColor = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your notes",
                    style = MaterialTheme.typography.headlineLarge
                )
                IconButton(onClick = onSortClicked) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sort),
                        contentDescription = "Sort notes"
                    )
                }
            }

            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically(),
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    noteOrder = state.noteOrder,
                    onOrderChange = onOrderChanged
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.notes) { note ->
                    NoteItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            },
                        note = note,
                        onDelete = {
                            onDeleteNote(it)
                            scope.launch {
                                val result = snackBarHostState.showSnackbar(
                                    message = "Note deleted",
                                    actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    onRestoreNote()
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    ComposeNoteappTheme {
        NotesContent(state = NotesState(notes = listOf(), isOrderSectionVisible = false),
            onAddEditNoteClicked = {},
            onSortClicked = {},
            onOrderChanged = {},
            onDeleteNote = {},
            onRestoreNote = {})
    }
}