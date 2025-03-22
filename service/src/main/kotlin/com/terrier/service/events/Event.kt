package com.terrier.service.events

import jakarta.persistence.Entity

@Entity
class Event {
    var id: String? = null
    var name: String? = null
    var startDate: String? = null
    var endDate: String? = null
    var description: String? = null
    var location: String? = null
    var sponsorOrgIds: List<String>? = null
    var hackerIds: List<String>? = null
    var createdAt: String? = null
    var updatedAt: String? = null
}