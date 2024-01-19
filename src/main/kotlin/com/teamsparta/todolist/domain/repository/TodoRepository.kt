package com.teamsparta.todolist.domain.repository

import com.teamsparta.todolist.domain.repository.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
interface TodoRepository  : JpaRepository<Todo, Long> {
    fun findAllByUserId (userId:Long) : List<Todo>
}