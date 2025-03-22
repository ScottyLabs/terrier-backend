package com.terrier.service.projects

import com.terrier.service.team.Team
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import java.util.UUID
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
class Project (
    @Id
    val id : UUID = UUID.randomUUID(),
    var name : String,
    @JoinColumn(name = "team_id", nullable = false)
    val team : Team,
    var description : String,
    @CreationTimestamp
    val createdAt : Instant,
    @UpdateTimestamp
    var updatedAt : Instant,
)