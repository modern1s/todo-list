package com.teamsparta.todolist.domain.controller.request

data class SignUpRequest (
    val email : String,
    val password : String,
    val userName : String
)