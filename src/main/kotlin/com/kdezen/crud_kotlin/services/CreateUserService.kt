package com.kdezen.crud_kotlin.services

import com.kdezen.crud_kotlin.dtos.User
import com.kdezen.crud_kotlin.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CreateUserService(@Autowired private val userRepository: UserRepository) {

    fun create( user: User): User {
        val userResult = userRepository.save(user)
        return userResult
    }
}