package com.terrier.service.hackathon

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Hackathon (
    @Id
    val id: UUID = UUID.randomUUID(),

    val name: String,

    val website: String,

    val year: String,

    @CreationTimestamp
    var createdAt: Instant,

    @UpdateTimestamp
    var updatedAt: Instant,
)