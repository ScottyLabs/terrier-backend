package com.terrier.service.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class User (
    @Id
    val id: UUID = UUID.randomUUID(),
)