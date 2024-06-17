package com.shahtott.compose_note_app.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shahtott.compose_note_app.feature_note.domain.util.NoteOrder
import com.shahtott.compose_note_app.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {

    Column {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title
            ) {
                onOrderChange(NoteOrder.Title(noteOrder.orderType))
            }
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date
            ) {
                onOrderChange(NoteOrder.Date(noteOrder.orderType))
            }
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is NoteOrder.Color
            ) {
                onOrderChange(NoteOrder.Color(noteOrder.orderType))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending
            ) {
                onOrderChange(noteOrder.copy(orderType = OrderType.Ascending))
            }
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder is NoteOrder.Date
            ) {
                onOrderChange(noteOrder.copy(orderType = OrderType.Descending))
            }
        }
    }


}
