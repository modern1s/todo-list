package com.teamsparta.todolist.domain.controller.request

import java.time.ZonedDateTime

data class CreateTodoRequest(
    val title: String?,
    val description: String?,
)