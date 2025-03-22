package com.terrier.service.events

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Event (
    @Id
    val id: UUID = UUID.randomUUID(),

    var name: String,

    @CreationTimestamp
    var startDate: Instant,

    @UpdateTimestamp
    var endDate: Instant,

    var description: String,
)