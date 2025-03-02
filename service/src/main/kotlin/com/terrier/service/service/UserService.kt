package com.terrier.service.service

import com.terrier.model.User
import com.terrier.service.entity.UserEntity
import com.terrier.service.exception.ResourceAlreadyExistsException
import com.terrier.service.exception.ResourceNotFoundException
import com.terrier.service.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll().map { it.toDto() }
    }

    fun getUserById(id: UUID): User {
        return userRepository.findById(id)
            .map { it.toDto() }
            .orElseThrow { ResourceNotFoundException("User not found with id: $id") }
    }

    @Transactional
    fun createUser(user: User): User {
        if (userRepository.existsByEmail(user.email)) {
            throw ResourceAlreadyExistsException("User already exists with email: ${user.email}")
        }

        val userEntity = UserEntity(
            id = user.id,
            idp = user.idp,
            email = user.email,
            name = user.name
        )

        val savedUser = userRepository.save(userEntity)
        return savedUser.toDto()
    }

    @Transactional
    fun updateUser(id: UUID, user: User): User {
        val existingUser = userRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("User not found with id: $id") }

        // Check if email is being changed and already exists
        if (user.email != existingUser.email && userRepository.existsByEmail(user.email)) {
            throw ResourceAlreadyExistsException("Email already in use: ${user.email}")
        }

        val updatedUser = existingUser.copy(
            idp = user.idp,
            email = user.email,
            name = user.name
        )

        val savedUser = userRepository.save(updatedUser)
        return savedUser.toDto()
    }

    @Transactional
    fun deleteUser(id: UUID) {
        if (!userRepository.existsById(id)) {
            throw ResourceNotFoundException("User not found with id: $id")
        }
        userRepository.deleteById(id)
    }

    // Extension function to convert Entity to DTO
    private fun UserEntity.toDto(): User {
        return User().apply {
            id = this@toDto.id
            idp = this@toDto.idp
            email = this@toDto.email
            name = this@toDto.name
            createdAt = this@toDto.createdAt
            updatedAt = this@toDto.updatedAt
        }
    }
}