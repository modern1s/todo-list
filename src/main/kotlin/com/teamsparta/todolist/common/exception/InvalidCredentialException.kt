package com.teamsparta.todolist.common.exception

data class InvalidCredentialException(
    override val message: String? = "The credential is invalid"
): RuntimeException()
