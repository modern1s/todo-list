package com.teamsparta.todolist.domain.service


import com.teamsparta.todolist.domain.repository.UserRepository
import com.teamsparta.todolist.domain.repository.model.User
import com.teamsparta.todolist.domain.service.dto.UserDto
import org.springframework.security.crypto.factory.PasswordEncoderFactories

open class UserService(
    private val userRepository: UserRepository,
){
    fun newUser(userDto: UserDto): UserDto {
            val user: User? = userRepository.findByEmail(userDto.email)
        if (user != null) {
            throw error("이미 등록된 email 입니다.")
        }
        val createuser = userRepository.save(
            User(
                userDto.email,
                PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userDto.password),
                userDto.userName,
            )
        )
        return createuser.toDto()

    }

}