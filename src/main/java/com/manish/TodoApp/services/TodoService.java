package com.manish.TodoApp.services;

import com.manish.TodoApp.entity.Todo;

import java.util.List;


public interface TodoService {
    List<Todo> getAll();

    void add(Todo todo);

    void delete(Long id);

    void update(Todo todo, Long id);

    Todo getById(Long id);
}
