package com.terrier.service.submission

import com.terrier.service.project.Project
import com.terrier.service.track.Track
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Submission (
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    val project: Project,

    @ManyToOne
    val track: Track,

    val submittedAt: Instant,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)