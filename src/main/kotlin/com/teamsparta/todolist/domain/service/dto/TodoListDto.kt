package com.teamsparta.todolist.domain.service.dto

import com.teamsparta.todolist.domain.repository.model.Todo
import java.time.LocalDate
import java.time.ZonedDateTime

data class TodoListDto(
    val id :Long? = null,
    val todoDate: LocalDate,
    val userName: String,
    val createdAt: ZonedDateTime?= null,
)
