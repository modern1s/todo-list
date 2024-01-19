package com.teamsparta.todolist.domain.repository.model

import com.teamsparta.todolist.domain.service.dto.TodoListDto
import com.teamsparta.todolist.domain.service.dto.UserDto
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table
class User(
    email: String,
    password: String,
    userName: String,

    ){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false, length = 30, updatable = false)
    var email = email

    @Column(nullable = false, length = 100)
    var password = password

    @Column(nullable = false, length = 10)
    var userName = userName



    fun toDto(): UserDto {
        return UserDto(
            id = id!!,
            email = this.email,
            password = this.password,
            userName = this.userName,
            createdAt = this.createdAt
        )
    }
}