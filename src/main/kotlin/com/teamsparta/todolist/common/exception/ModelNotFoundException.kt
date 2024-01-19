package com.teamsparta.todolist.common.exception

data class ModelNotFoundException(val modelName: String, val id: Long?): RuntimeException(
    "model $modelName not found with given id: $id"
)
