package com.manish.TodoApp.controller;

import com.manish.TodoApp.entity.Todo;
import com.manish.TodoApp.services.TodoService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> getAll(){
        return this.todoService.getAll();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable(value = "id") Long id){
        Todo t = this.todoService.getById(id);
        return (t == null ? new Todo() : t);
    }

    @PostMapping("/add")
    public void add(@RequestBody Todo todo){
        todo.setTimestamp(new Timestamp(System.currentTimeMillis()));
        this.todoService.add(todo);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.todoService.delete(id);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody Todo todo, @PathVariable(value = "id") Long id){
        this.todoService.update(todo, id);
    }
}
