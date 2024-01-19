package com.teamsparta.todolist.domain.repository.model


import com.teamsparta.todolist.domain.service.dto.UserDto
import jakarta.persistence.*


@Entity
@Table(name = "user")
class User(
    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "username", nullable = false)
    val userName: String,


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toDto(): UserDto {
        return UserDto(
            id = id!!,
            email = this.email,
            password = this.password,
            userName = this.userName,
        )

}
}