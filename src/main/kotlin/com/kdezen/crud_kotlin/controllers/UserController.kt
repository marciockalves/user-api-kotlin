package com.kdezen.crud_kotlin.controllers

import com.kdezen.crud_kotlin.dtos.User
import com.kdezen.crud_kotlin.services.CreateUserService
import com.kdezen.crud_kotlin.services.FindOneUserService
import com.kdezen.crud_kotlin.services.ListUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/users")
class UserController(
    @Autowired private val listUserService: ListUserService,
    @Autowired private  val createUserService: CreateUserService,
    @Autowired private val findOneUserService: FindOneUserService
){

    @GetMapping
    fun getAllUsers(): List<User>{
        return listUserService.findAll()
    }

    @GetMapping("/{id}")
    fun getFindById(@PathVariable("id") userId: Int): ResponseEntity<User>{
        val responseUser : User? = findOneUserService.find("id", userId.toLong())
        return ResponseEntity(responseUser, HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@RequestBody requestUser: User): ResponseEntity<User>{
        val responseUser = createUserService.create(requestUser)

        return ResponseEntity(responseUser, HttpStatus.CREATED)
    }
}