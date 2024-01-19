package com.teamsparta.todolist.domain.controller.response

import com.teamsparta.todolist.domain.repository.model.Todo
import jdk.jfr.Description
import java.time.LocalDate
import java.time.ZonedDateTime

data class TodoResponse (
    val todoListId : Long,
    val title: String?,
    val description: String?,
    val createdAt : ZonedDateTime?
)