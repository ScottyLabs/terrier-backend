package com.terrier.service.attendee

import com.terrier.service.hackathon.Hackathon
import com.terrier.service.user.User
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "hackathon_id"])]
)
class Attendee (
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    val hackathon: Hackathon,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)