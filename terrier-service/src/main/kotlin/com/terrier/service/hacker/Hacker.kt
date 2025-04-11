package com.terrier.service.hacker

import com.terrier.service.attendee.Attendee
import com.terrier.service.hackathon.Hackathon
import com.terrier.service.team.Team
import com.terrier.service.user.User
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Version
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Hacker (
    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "attendee_id")
    val attendee : Attendee,

    @ManyToOne
    @JoinColumn(name = "team_id")
    val team : Team,

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    val hackathon : Hackathon,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)