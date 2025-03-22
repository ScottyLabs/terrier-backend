package com.terrier.service.events

import jakarta.persistence.Entity
import java.time.LocalDateTime
import java.util.UUID

@Entity
class Event {
    var id: UUID? = null
    var name: String? = null
    var startDate: LocalDateTime? = null
    var endDate: LocalDateTime? = null
    var description: String? = null
    var location: String? = null
    var sponsorOrgIds: List<UUID>? = null
    var hackerIds: List<UUID>? = null
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null
}