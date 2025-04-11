package com.terrier.service.judge

import com.terrier.service.track.Track
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class JudgeAssignment (
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    val judge: Judge,

    @ManyToOne
    val track: Track,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)