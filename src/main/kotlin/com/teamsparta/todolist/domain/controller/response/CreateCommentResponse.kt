package com.teamsparta.todolist.domain.controller.response

import jakarta.persistence.Id
import java.time.LocalDate
import java.time.ZonedDateTime

data class CreateCommentResponse(
    val todoListId: Long,
    val content : String,
    val userId: Long,
    val createdAt : ZonedDateTime
)
