package com.terrier.service.events

import com.terrier.api.EventsApiDelegate
import com.terrier.model.Event
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.UUID

class EventsApiDelegateImpl(
    private val eventRepository: EventRepository
) : EventsApiDelegate {
    override fun eventsEventIdDelete(eventId: String): ResponseEntity<Unit> {
        eventRepository.deleteById(eventId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    override fun eventsEventIdGet(eventId: UUID): ResponseEntity<Event> {
        val event = eventRepository.findById(eventId)
    }
}