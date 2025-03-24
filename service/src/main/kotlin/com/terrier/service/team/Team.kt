package com.terrier.service.team

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Team (
    @Id
    val id : UUID = UUID.randomUUID(),

    var name : String,

    @CreationTimestamp
    val createdAt : Instant,

    @UpdateTimestamp
    var updatedAt : Instant,
)