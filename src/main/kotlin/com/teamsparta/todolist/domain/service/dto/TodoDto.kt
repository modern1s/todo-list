package com.teamsparta.todolist.domain.service.dto

import jdk.jfr.Description
import java.time.ZonedDateTime

data class TodoDto(
    val id : Long? = null,
    val todoListId : Long,
    val title : String?,
    val description: String?,
    val createdAt : ZonedDateTime?=null,

)
