package com.terrier.service.event

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

    var startDate: Instant,

    var endDate: Instant,

    var description: String,

    var location: String,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)