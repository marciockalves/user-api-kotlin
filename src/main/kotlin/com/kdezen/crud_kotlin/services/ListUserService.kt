package com.kdezen.crud_kotlin.services

import com.kdezen.crud_kotlin.dtos.User
import com.kdezen.crud_kotlin.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListUserService(@Autowired private val userRepository: UserRepository) {

    fun findAll(): List<User>{
        return userRepository.findAll().toList()
    }

}