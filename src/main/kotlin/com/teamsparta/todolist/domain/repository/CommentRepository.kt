package com.teamsparta.todolist.domain.repository


import com.teamsparta.todolist.domain.repository.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository <Comment, Long> {

}