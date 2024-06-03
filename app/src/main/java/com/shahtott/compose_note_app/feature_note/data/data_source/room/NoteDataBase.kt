package com.shahtott.compose_note_app.feature_note.data.data_source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shahtott.compose_note_app.feature_note.data.data_source.dao.NoteDao
import com.shahtott.compose_note_app.feature_note.data.model.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1,
//    exportSchema = false,
//    views = [NoteEntity::class]
)
abstract class NoteDataBase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object    {
        const val DATABASE_NAME = "note_database"
    }
}