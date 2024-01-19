package com.teamsparta.todolist.domain.controller


import com.teamsparta.todolist.domain.controller.request.CreateCommentRequest
import com.teamsparta.todolist.domain.controller.request.CreateTodoListRequest
import com.teamsparta.todolist.domain.controller.request.CreateTodoRequest
import com.teamsparta.todolist.domain.controller.response.CreateCommentResponse
import com.teamsparta.todolist.domain.controller.response.TodoListResponse
import com.teamsparta.todolist.domain.controller.response.TodoResponse
import com.teamsparta.todolist.domain.service.TodoListService
import com.teamsparta.todolist.domain.service.dto.CommentDto
import com.teamsparta.todolist.domain.service.dto.TodoDto
import com.teamsparta.todolist.domain.service.dto.TodoListDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class TodoListController(
    private val todoListService: TodoListService
) {

    @GetMapping("api/v1/todoList")
    fun getTodoList(
        @RequestHeader userId: Long) :ResponseEntity<List<TodoResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(todoListService.getTodoList(userId))
    }

    @PostMapping("api/v1/todoList")
    fun createTodoList(@RequestBody creatTodoListRequest: CreateTodoListRequest): ResponseEntity<TodoListResponse> {
        val result = todoListService.createTodoList(
            TodoListDto(
                todoDate = creatTodoListRequest.date,
                userName = creatTodoListRequest.userName,
            )
        )
        return ResponseEntity.status(200).body(
            TodoListResponse(
                todoDate = result.todoDate,
                userName = result.userName,
                createdAt = result.createdAt,
            )
        )
    }
    @DeleteMapping("api/v1/todolist/{todoListId}")
       fun deleteTodoList(
            @PathVariable todoListId: Long,
            @RequestHeader userId: Long): ResponseEntity<Unit>{
            todoListService.deleteTodoList(todoListId,userId)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
       }



    @PostMapping("/api/v1/todoList/{todoListId}")
    fun createTodo(
        @PathVariable todoListId: Long,
        @RequestBody createTodoRequest: CreateTodoRequest
    ): ResponseEntity<TodoResponse> {
        val result = todoListService.createTodo(
            TodoDto(
                todoListId =  todoListId,
                title = createTodoRequest.title,
                description = createTodoRequest.description
            )

        )
        return ResponseEntity.status(200).body(
            TodoResponse(
                todoListId = result.todoListId,
                title = result.title,
                description =  result.description,
                createdAt = result.createdAt,
            )
        )
    }

    @PostMapping("/api/v1/todoList/{todoListId}/comment")
    fun createComment(
        @PathVariable todoListId: Long,
        @RequestHeader userId : Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ):ResponseEntity<CreateCommentResponse>{
        val result = todoListService.createComment(
            CommentDto(
                todoListId = todoListId,
                userId = userId,
                content = createCommentRequest.content,
                createdAt = createCommentRequest.createdAt

            )
        )
        return ResponseEntity.status(200).body(
            CreateCommentResponse(
                todoListId = result.todoListId,
                userId= result.userId,
                content = result.content,
                createdAt = result.createdAt
            )
        )
    }
}
