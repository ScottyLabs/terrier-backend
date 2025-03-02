package com.terrier.service.controller

import com.terrier.api.UsersApi
import com.terrier.model.User
import com.terrier.service.exception.InvalidRequestException
import com.terrier.service.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class UserController(private val userService: UserService) : UsersApi {

    override fun usersGet(): ResponseEntity<List<User>> {
        val users = userService.getAllUsers()
        return ResponseEntity.ok(users)
    }

    override fun usersPost(user: User): ResponseEntity<User> {
        val createdUser = userService.createUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }

    override fun usersUserIdGet(userId: String): ResponseEntity<User> {
        val id = try {
            UUID.fromString(userId)
        } catch (e: IllegalArgumentException) {
            throw InvalidRequestException("Invalid user ID format: $userId")
        }

        val user = userService.getUserById(id)
        return ResponseEntity.ok(user)
    }

    override fun usersUserIdPut(userId: String, user: User): ResponseEntity<User> {
        val id = try {
            UUID.fromString(userId)
        } catch (e: IllegalArgumentException) {
            throw InvalidRequestException("Invalid user ID format: $userId")
        }

        val updatedUser = userService.updateUser(id, user)
        return ResponseEntity.ok(updatedUser)
    }

    override fun usersUserIdDelete(userId: String): ResponseEntity<Void> {
        val id = try {
            UUID.fromString(userId)
        } catch (e: IllegalArgumentException) {
            throw InvalidRequestException("Invalid user ID format: $userId")
        }

        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }
}