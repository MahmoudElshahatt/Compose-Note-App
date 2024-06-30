package com.shahtott.compose_note_app.feature_note.data.mappers

import com.shahtott.compose_note_app.feature_note.data.model.NoteEntity
import com.shahtott.compose_note_app.feature_note.domain.model.Note

fun NoteEntity.toNote() = Note(
    title = this.title,
    content = this.content,
    timeStamp = this.timeStamp,
    color = this.color,
    id = this.id
)

fun Note.toNoteEntity() = NoteEntity(
    title = this.title,
    content = this.content,
    timeStamp = this.timeStamp,
    color = this.color
)