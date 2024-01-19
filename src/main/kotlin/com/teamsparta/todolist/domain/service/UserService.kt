package com.teamsparta.todolist.domain.service

import com.teamsparta.todolist.infra.security.jwt.PasswordEncoderConfig
import com.teamsparta.todolist.common.exception.InvalidCredentialException
import com.teamsparta.todolist.common.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.controller.request.LoginRequest
import com.teamsparta.todolist.domain.controller.response.LoginResponse
import com.teamsparta.todolist.domain.repository.UserRepository
import com.teamsparta.todolist.domain.repository.model.User
import com.teamsparta.todolist.domain.service.dto.UserDto
import com.teamsparta.todolist.infra.security.jwt.JwtPlugin
import io.jsonwebtoken.Jwt
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

open class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin

    ) {
    fun login(loginRequest: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(loginRequest.email) ?: throw ModelNotFoundException("User", null)
        if( !passwordEncoder.matches(loginRequest.password, user.password)  ){
            throw InvalidCredentialException()
        }

        return LoginResponse(
            accessToken = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = user.email
            )
        )
    }

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

