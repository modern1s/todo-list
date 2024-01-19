package com.teamsparta.todolist.domain.repository.model

import com.teamsparta.todolist.domain.service.dto.TodoDto
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity(name = "todo")
class Todo(
    @ManyToOne
    @JoinColumn(name = "todo_list_id", nullable = false)
    var todoList: TodoList,

    @Column(name = "title")
    var title: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "created_at")
    var createdAt : ZonedDateTime,

    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    fun toDto(): TodoDto {
        return TodoDto(
            id = this.id!!,
            todoListId = todoList.id!!,
            title = this.title,
            description = this.description,
            createdAt = this.createdAt
        )
    }
}
