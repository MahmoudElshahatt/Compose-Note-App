package com.shahtott.compose_note_app.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shahtott.compose_note_app.ui.theme.ComposeNoteappTheme

@Composable
fun DefaultRadioButton(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onSelected: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary,
                unselectedColor = MaterialTheme.colorScheme.onBackground
            ),
            onClick = onSelected
        )
        Spacer(modifier = modifier.width(6.dp))

        Text(text = text, style = MaterialTheme.typography.bodySmall)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultRadioButtonPreview() {
    ComposeNoteappTheme {
        DefaultRadioButton(
            text = "Android",
            selected = true,
            onSelected = {}
        )
    }
}