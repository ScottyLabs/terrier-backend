package com.terrier.service.sponsor

import com.terrier.service.user.User
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.UUID

@Entity
class Sponsor (
    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "user_id")
    val user : User,

    @ManyToOne
    @JoinColumn(name = "sponsor_org_id")
    val sponsorOrg: SponsorOrg,

    @CreationTimestamp
    val createdAt: Instant,

    @UpdateTimestamp
    val updatedAt: Instant,
)