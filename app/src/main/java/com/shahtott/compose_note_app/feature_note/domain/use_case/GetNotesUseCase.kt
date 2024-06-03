package com.shahtott.compose_note_app.feature_note.domain.use_case


import com.shahtott.compose_note_app.feature_note.domain.repository.NoteRepository
import com.shahtott.compose_note_app.feature_note.domain.util.NoteOrder
import com.shahtott.compose_note_app.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.map
import java.util.Locale

class GetNotesUseCase(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ) = noteRepository.getNotes().map { notes ->
        when (noteOrder.orderType) {

            OrderType.Ascending -> {
                when (noteOrder) {
                    is NoteOrder.Color -> notes.sortedBy { it.color }
                    is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                    is NoteOrder.Title -> notes.sortedBy { it.title.lowercase(Locale.ROOT) }
                }
            }

            OrderType.Descending -> {
                when (noteOrder) {
                    is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                    is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase(Locale.ROOT) }
                }
            }
        }
    }


}