package com.teamsparta.todolist.domain.repository.model

import com.teamsparta.todolist.domain.service.dto.CommentDto
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity(name = "comment")
class Comment (
    @Column(name = "todo_list_id")
    public var todoListId: Long,

    @Column(name = "user_id")
    public var userId: Long,

    @Column(name = "content")
    public var content: String,

    @Column(name = "created_at")
    public var createdAt : ZonedDateTime,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toDto(): CommentDto {
        return CommentDto(
            id = this.id!!,
            todoListId = this.todoListId,
            userId = this.userId,
            content = this.content,
            createdAt = this.createdAt
        )

    }
}