package com.manish.TodoApp.services;

import com.manish.TodoApp.entity.Todo;
import com.manish.TodoApp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    @Override
    public void add(Todo todo) {
        this.todoRepository.save(todo);
    }

    @Override
    public void delete(Long id) {
        this.todoRepository.deleteById(id);
    }

    @Override
    public void update(Todo todo, Long id) {
        Todo t = getById(id);
        t.setText(todo.getText());
        t.setTitle(todo.getTitle());
        this.todoRepository.save(t);
    }

    @Override
    public Todo getById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Todo not found"));
    }

}
