package com.teamsparta.todolist.domain.repository.model

import com.teamsparta.todolist.domain.service.dto.TodoListDto
import jakarta.persistence.*
import java.time.LocalDate
import java.time.ZonedDateTime

@Entity
@Table(name = "todoList")
class TodoList(

    @Column(name = "todo_date")
    var todoDate: LocalDate,

    @Column(name = "user_name")
    var userName: String,

    @Column(name = "create_at")
    var createdAt: ZonedDateTime,

    @OneToMany(mappedBy = "todoList")
    var todos : MutableList<Todo> = mutableListOf(),

    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    fun toDto(): TodoListDto {
        return TodoListDto(
            id = id!!,
            todoDate = this.todoDate,
            userName = this.userName,
            createdAt = this.createdAt
        )
    }
}

