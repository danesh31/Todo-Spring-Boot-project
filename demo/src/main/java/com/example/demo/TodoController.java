package com.example.demo;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) 
    {
        this.service = service;
    }

    @GetMapping("/all/{userId}")
    public List<TodoDTO> getAllTodosById(@PathVariable long userId) {
        return service.getAllTodosById(userId);
    }

    @GetMapping("single/{id}")
    public TodoDTO getTodoById(@PathVariable long id) {
        return service.getTodoById(id);
    }

    @PostMapping("/{userId}")
    public Todo createTodo(@PathVariable long userId,@RequestBody @NonNull Todo todo) {
        return service.createTodo(userId,todo);
    }

    @PutMapping("update/{id}")
    public Todo updateTodo(@PathVariable long id, @RequestBody TodoDTO todto) {
        return service.updateTodo(id, todto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable long id) {
        service.deleteTodo(id);
    }
}
