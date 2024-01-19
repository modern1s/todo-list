package com.teamsparta.todolist.domain.service

import com.teamsparta.todolist.domain.controller.request.SignUpRequest
import com.teamsparta.todolist.domain.controller.response.UserResponse
import com.teamsparta.todolist.domain.repository.UserRepository
import com.teamsparta.todolist.domain.repository.model.User
import com.teamsparta.todolist.domain.service.dto.UserDto
import org.springframework.security.crypto.factory.PasswordEncoderFactories

class UserService(
    private val userRepository: UserRepository,
) : {
    fun newUser(signUpRequest: SignUpRequest): UserDto {
        val user: User? = userRepository.findByEmail(signUpRequest.email)
        if (user != null) {
            throw error("이미 등록된 email 입니다.")
        }
        val createuser = userRepository.save(
            User(
                signUpRequest.email,
                PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(signUpRequest.password),
                signUpRequest.userName,
            )
        )
        return createuser.toDto()

    }

}