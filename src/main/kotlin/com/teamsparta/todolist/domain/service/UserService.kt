package com.teamsparta.todolist.domain.service

import com.teamsparta.todolist.domain.controller.request.SignUpRequest
import com.teamsparta.todolist.domain.controller.response.SignUpResponse
import com.teamsparta.todolist.domain.repository.UserRepository
import com.teamsparta.todolist.domain.repository.model.User
import com.teamsparta.todolist.domain.service.dto.UserDto
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import java.time.ZonedDateTime

class UserService (
    private val userRepository: UserRepository
): {
    fun newUser (signUpRequest: SignUpRequest): SignUpResponse {
        var user: User? = userRepository.findByEmail(signUpRequest.email)
        if (user != null) {
            throw error("이미 등록된 email 입니다.")
        }
        user = User(
            signUpRequest.email,
            PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(signUpRequest.password),
            signUpRequest.userName,
        )
       return userRepository.toResponse

    }

}