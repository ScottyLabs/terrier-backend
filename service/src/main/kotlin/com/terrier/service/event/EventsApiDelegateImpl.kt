package com.terrier.service.event

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

}