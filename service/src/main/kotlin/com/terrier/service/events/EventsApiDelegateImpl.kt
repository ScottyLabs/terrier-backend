package com.terrier.service.events

import com.terrier.api.EventsApiDelegate
import com.terrier.api.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.UUID
import org.mapstruct.factory.Mappers
import com.terrier.model.EventModel
import org.springframework.data.repository.findByIdOrNull


@Service
class EventsApiDelegateImpl(
    private val eventRepository: EventRepository
) : EventsApiDelegate {
    private val eventMapper = Mappers.getMapper(EventMapper::class.java)

    override fun eventsEventIdDelete(eventId: UUID): ResponseEntity<Unit> {
        eventRepository.deleteById(eventId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    override fun eventsEventIdGet(eventId: UUID): ResponseEntity<EventModel> {
        val event = eventRepository.findByIdOrNull(eventId) ?: throw NotFoundException("Event with id $eventId not found")
        return ResponseEntity.ok(eventMapper.toEventModel(event))
    }

    override fun eventsEventIdPut(eventId: UUID, eventModel: EventModel): ResponseEntity<EventModel> {
        val existingEvent = eventRepository.findByIdOrNull(eventId)
            ?: throw NotFoundException("Event with id $eventId not found")

        val updatedEvent = eventMapper.toEvent(eventModel).apply {

        }

        val savedEvent = eventRepository.save(updatedEvent)
        return ResponseEntity.ok(eventMapper.toEventModel(savedEvent))
    }

    override fun eventsGet(): ResponseEntity<List<EventModel>> {
        val events = eventRepository.findAll().map { eventMapper.toEventModel(it) }
        return ResponseEntity.ok(events)
    }

    override fun eventsPost(eventModel: EventModel): ResponseEntity<EventModel> {
        val event = eventMapper.toEvent(eventModel)
        eventRepository.save(event)
        return ResponseEntity.status(HttpStatus.CREATED).body(eventMapper.toEventModel(event))
    }
}