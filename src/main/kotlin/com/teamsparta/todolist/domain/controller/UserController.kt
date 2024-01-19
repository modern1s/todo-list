package com.teamsparta.todolist.domain.controller

import com.teamsparta.todolist.domain.controller.request.LoginRequest
import com.teamsparta.todolist.domain.controller.request.SignUpRequest
import com.teamsparta.todolist.domain.controller.response.LoginResponse
import com.teamsparta.todolist.domain.controller.response.UserResponse
import com.teamsparta.todolist.domain.service.UserService
import com.teamsparta.todolist.domain.service.dto.UserDto
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class UserController(
    private val userService: UserService
) {

    @PostMapping("/api/v1/users/login")
    fun login(@RequestBody loginRequest: LoginRequest):ResponseEntity<LoginResponse> {
      return ResponseEntity
          .status(HttpStatus.OK)
          .body(userService.login(loginRequest))
    }

    @PostMapping("/api/v1/users/signup")
    fun signup(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<UserResponse> {
        val result = userService.newUser(
            UserDto(
                email = signUpRequest.email,
                password = signUpRequest.password,
                userName = signUpRequest.userName
            )
        )
        return  ResponseEntity.status(HttpStatus.CREATED).body(
            UserResponse(
                email = result.email,
                userName = result.userName,
            )
        )
    }
}