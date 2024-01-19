package com.teamsparta.todolist.domain.service.dto

import java.time.ZonedDateTime

data class UserDto(
    val id : Long? = null,
    val email : String,
    val password : String,
    val userName: String,
)
