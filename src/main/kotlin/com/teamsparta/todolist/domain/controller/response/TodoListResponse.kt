package com.teamsparta.todolist.domain.controller.response

import com.teamsparta.todolist.domain.repository.model.Todo
import java.time.LocalDate
import java.time.ZonedDateTime

class TodoListResponse (
    val todoDate: LocalDate,
    val userName: String,
    val createdAt: ZonedDateTime?
)