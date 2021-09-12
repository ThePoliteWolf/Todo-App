package com.manish.TodoApp.utils;

import com.manish.TodoApp.entity.Todo;

import java.sql.Timestamp;

public class TodoGenerator {
    public static Todo getTodo(Long id, String title, String text, Timestamp timestamp){
        Todo todo = new Todo();
        todo.setId(id);
        todo.setText(text);
        todo.setTimestamp(timestamp);
        todo.setTitle(title);

        return todo;
    }
}
