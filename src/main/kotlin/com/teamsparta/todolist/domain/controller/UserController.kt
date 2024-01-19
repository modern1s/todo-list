package com.teamsparta.todolist.domain.controller

import com.teamsparta.todolist.domain.controller.request.LoginRequest
import com.teamsparta.todolist.domain.controller.request.SignUpRequest
import com.teamsparta.todolist.domain.controller.response.SignUpResponse
import com.teamsparta.todolist.domain.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class UserController(
    private val userService: UserService
) {
    @PostMapping("/users/signup")
    fun signup(@RequestBody @Valid signUpRequest: SignUpRequest): ResponseEntity<SignUpResponse> {
        val signUpResponse = userService.newUser(signUpRequest)
        return  ResponseEntity.status(HttpStatus.CREATED).body(signUpResponse)
    }
}