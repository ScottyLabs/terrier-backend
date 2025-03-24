package com.terrier.service.hacker

import com.terrier.service.team.Team
import com.terrier.service.user.User
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.util.UUID

@Entity
class Hacker (
    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "user_id")
    val user : User,

    @ManyToOne
    @JoinColumn(name = "team_id")
    val team : Team,
)