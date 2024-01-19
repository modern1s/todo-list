package com.teamsparta.todolist.domain.repository

import com.teamsparta.todolist.domain.repository.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}