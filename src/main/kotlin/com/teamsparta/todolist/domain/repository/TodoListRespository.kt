package com.teamsparta.todolist.domain.repository

import com.teamsparta.todolist.domain.repository.model.TodoList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoListRepository : JpaRepository<TodoList, Long> {
    fun findByIdAndUserId(id:Long, userId: Long) : TodoList
}