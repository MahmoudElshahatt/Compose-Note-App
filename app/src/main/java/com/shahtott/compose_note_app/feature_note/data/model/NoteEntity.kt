package com.shahtott.compose_note_app.feature_note.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "notes")
data class NoteEntity(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
)
