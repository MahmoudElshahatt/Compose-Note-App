package com.shahtott.compose_note_app.feature_note.domain.util


sealed class InvalidNoteException() : Throwable() {
    class InvalidTitleNoteException : InvalidNoteException()
    class InvalidContentNoteException : InvalidNoteException()
}
