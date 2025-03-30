package com.terrier.service.event

import com.terrier.model.EventModel
import org.mapstruct.Mapper

@Mapper
interface EventMapper {
    fun toEvent(eventModel: EventModel): Event
    fun toEventModel(event: Event): EventModel
}