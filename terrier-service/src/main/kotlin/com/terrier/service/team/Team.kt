package com.terrier.service.team

import com.terrier.service.hackathon.Hackathon
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Team (
    @Id
    val id : UUID = UUID.randomUUID(),

    var name : String,

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    val hackathon : Hackathon,

    @CreationTimestamp
    val createdAt : Instant,

    @UpdateTimestamp
    var updatedAt : Instant,
)