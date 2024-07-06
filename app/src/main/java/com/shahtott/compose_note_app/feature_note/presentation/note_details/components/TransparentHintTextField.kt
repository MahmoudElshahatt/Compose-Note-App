package com.shahtott.compose_note_app.feature_note.presentation.note_details.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChanged:(String) -> Unit
) {
}