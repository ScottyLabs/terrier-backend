package com.terrier.service.organizer

import com.terrier.service.attendee.Attendee
import com.terrier.service.hackathon.Hackathon
import com.terrier.service.team.Team
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Organizer (
    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "attendee_id")
    val attendee : Attendee,

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    val hackathon : Hackathon,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)