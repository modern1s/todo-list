package com.teamsparta.todolist.domain.controller.request


import java.time.LocalDate


data class CreateTodoListRequest (
    val date: LocalDate,
    val userName: String,
)


