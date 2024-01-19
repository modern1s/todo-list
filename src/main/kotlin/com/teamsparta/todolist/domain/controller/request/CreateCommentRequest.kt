package com.teamsparta.todolist.domain.controller.request

import java.time.LocalDate
import java.time.ZonedDateTime

data class CreateCommentRequest (
    val content : String,
    val createdAt : ZonedDateTime
    )


