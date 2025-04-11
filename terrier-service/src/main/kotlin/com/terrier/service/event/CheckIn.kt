package com.terrier.service.event

import com.terrier.service.hacker.Hacker
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.*

@Entity
class CheckIn (
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    @JoinColumn(name = "hacker_id")
    val hacker: Hacker,

    @ManyToOne
    @JoinColumn(name = "event_id")
    val event: Event,

    val timestamp: Instant = Instant.now(),

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)