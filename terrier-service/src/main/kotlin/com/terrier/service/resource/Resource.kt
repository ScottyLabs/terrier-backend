package com.terrier.service.resource

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import java.util.*

@Entity
class Resource (
    @Id val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    val content: String,

    @Column(nullable = false)
    val senderId: UUID,

    @OneToMany(mappedBy = "resource", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val recipients: MutableSet<ResourceRecipient> = mutableSetOf(),

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: Instant = Instant.now()
)