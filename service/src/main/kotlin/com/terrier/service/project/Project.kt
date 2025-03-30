package com.terrier.service.project

import com.terrier.service.team.Team
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.util.UUID
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
class Project (
    @Id
    val id : UUID = UUID.randomUUID(),

    var name : String,

    @OneToOne
    @JoinColumn(name = "team_id")
    val team : Team,

    var description : String,

    @CreationTimestamp
    val createdAt : Instant,

    @UpdateTimestamp
    var updatedAt : Instant,
)