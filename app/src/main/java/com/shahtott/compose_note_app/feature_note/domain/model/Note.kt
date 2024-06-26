package com.shahtott.compose_note_app.feature_note.domain.model


import com.shahtott.compose_note_app.ui.theme.BabyBlue
import com.shahtott.compose_note_app.ui.theme.LightGreen
import com.shahtott.compose_note_app.ui.theme.RedOrange
import com.shahtott.compose_note_app.ui.theme.RedPink
import com.shahtott.compose_note_app.ui.theme.Violet

data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(
            RedOrange, LightGreen, Violet,
            BabyBlue, RedPink
        )
    }
}

