package com.example.demo;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {


        private final TodoRepository repository;
        private final UserRepository userRepo;
        private final TodoMapper mapper;

        public TodoService(TodoRepository repository,TodoMapper mapper,UserRepository userRepo) {
            this.repository = repository;
            this.mapper=mapper;
            this.userRepo=userRepo;
        }

        public List<TodoDTO> getAllTodosById(Long userId) {
            List<Todo> todos= repository.findByUserId(userId);
            return mapper.todtolist(todos);
        }

        public TodoDTO getTodoById(long id) {
            Todo todo= repository.findById(id).orElse(null);
            return mapper.todto(todo);
        }

        public Todo createTodo(long userId,@NonNull Todo todo) {
            User user=userRepo.findById(userId).orElseThrow();
            todo.setUser(user);
            return repository.save(todo);
        }

        public Todo updateTodo(long id, TodoDTO todto) {
            return repository.findById(id)
                    .map(todo -> {
                        todo.setTitle(todto.getTitle());
                        todo.setDescription(todto.getDescription());
                        todo.setCompleted(todto.getCompleted());
                        return repository.save(todo);
                    })
                    .orElse(null);
        }

        public void deleteTodo(long id) {
            repository.deleteById(id);
        }
    }

