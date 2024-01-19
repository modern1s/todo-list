package com.teamsparta.todolist.domain.service.dto

import org.springframework.cglib.core.Local
import java.time.LocalDate
import java.time.ZonedDateTime

class CommentDto(
    val id : Long? = null,
    val todoListId: Long,
    val userId : Long,
    val content: String,
    val createdAt : ZonedDateTime
)
