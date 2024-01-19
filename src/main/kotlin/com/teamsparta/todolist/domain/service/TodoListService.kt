package com.teamsparta.todolist.domain.service




import com.teamsparta.todolist.domain.controller.response.TodoResponse
import com.teamsparta.todolist.domain.repository.CommentRepository
import com.teamsparta.todolist.domain.repository.TodoListRepository
import com.teamsparta.todolist.domain.repository.model.TodoList
import com.teamsparta.todolist.domain.repository.model.Todo
import com.teamsparta.todolist.domain.repository.TodoRepository
import com.teamsparta.todolist.domain.repository.model.Comment
import com.teamsparta.todolist.domain.service.dto.CommentDto
import com.teamsparta.todolist.domain.service.dto.TodoDto
import com.teamsparta.todolist.domain.service.dto.TodoListDto
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class TodoListService (
    private val todoListRepository: TodoListRepository,
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository
){
    @Transactional

    fun getTodoList(userId: Long): List<TodoResponse> {
        val todos = todoRepository.findAllByUserId(userId)
        return todos.map { todo ->
            TodoResponse(
                todoListId= todo.todoList.id!!,
                title = todo.title,
                description = todo.description,
                createdAt = todo.createdAt
            )
        }
    }

    @Transactional
    fun createTodoList(todoListDto: TodoListDto): TodoListDto {
        return todoListRepository.save(
          TodoList(
              todoDate = todoListDto.todoDate,
              userName = todoListDto.userName,
              createdAt = ZonedDateTime.now()
            )
        ).toDto()
    }
    @Transactional
    fun deleteTodoList (todoListId : Long, userId : Long){
        val todoListDelete = todoListRepository.findByIdAndUserId(todoListId,userId)
        todoListRepository.delete(todoListDelete)
    }
    @Transactional
    fun createTodo(todoDto: TodoDto): TodoDto {
        val todoList = todoListRepository.findByIdOrNull(todoDto.todoListId)?: throw Exception()
        return  todoRepository.save(
            Todo(
                todoList = todoList,
                title = todoDto.title,
                description = todoDto.description,
                createdAt = ZonedDateTime.now()
            )
        ).toDto()
    }
    @Transactional
    fun createComment(commentDto: CommentDto): CommentDto {
        return commentRepository.save(
            Comment(
        todoListId = commentDto.todoListId,
        userId = commentDto.userId,
        content = commentDto.content,
        createdAt = ZonedDateTime.now()
            )
        ).toDto()
    }
}