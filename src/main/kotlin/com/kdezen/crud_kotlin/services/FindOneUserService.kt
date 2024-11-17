package com.kdezen.crud_kotlin.services

import com.kdezen.crud_kotlin.dtos.User
import com.kdezen.crud_kotlin.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FindOneUserService(@Autowired private val userRepository: UserRepository) {

    fun <T> find(field: String, valueFields: T): User? {

        val listUser: List<User>

        val resultFind = selectedField(field, valueFields)

        return resultFind


    }

    private fun <T> selectedField(field: String, value: T ): User? {

        val actionFind = mapOf(
            "id" to { id: Long -> userRepository.findById(id)},
            "name" to { name: String -> userRepository.findByName(name)},
            "email" to {email: String -> userRepository.findByEmail(email)}
        )

        val resultAction= actionFind[field] as? (T) -> User

        return resultAction?.invoke(value)

    }

}