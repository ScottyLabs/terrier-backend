package com.terrier.service.resource

import com.terrier.service.attendee.Attendee
import com.terrier.service.team.Team
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "resource_recipients")
class ResourceRecipient(
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    val resource: Resource,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendee_id")
    final val attendee: Attendee? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    final val team: Team? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    final val recipientType: RecipientType
) {
    init {
        require((recipientType == RecipientType.ATTENDEE && attendee != null && team == null) ||
                (recipientType == RecipientType.TEAM && team != null && attendee == null)) {
            "Exactly one of attendee or team must be set, matching recipientType"
        }
    }
}

enum class RecipientType {
    TEAM,
    ATTENDEE
}