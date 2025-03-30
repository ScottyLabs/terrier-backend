package com.terrier.service.track

import com.terrier.service.sponsor.Sponsor
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Track (
    @Id
    val id: UUID = UUID.randomUUID(),

    val name: String,

    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    val sponsor: Sponsor?,

    val description: String,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)