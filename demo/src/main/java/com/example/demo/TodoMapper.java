package com.example.demo;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface TodoMapper {
    TodoDTO todto(Todo todo);
    List<TodoDTO> todtolist(List<Todo> todos);
    
}
