package com.kdezen.crud_kotlin.repositories

import com.kdezen.crud_kotlin.dtos.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{

    fun findByName(name: String): User

    fun findByEmail(email: String): User


}