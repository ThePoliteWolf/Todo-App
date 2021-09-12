package com.manish.TodoApp.services;

import com.manish.TodoApp.entity.Todo;
import com.manish.TodoApp.repository.TodoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TodoServiceImplTest {

    @Mock
    TodoServiceImpl todoService;

    @InjectMocks
    TodoRepository todoRepository;

    public static List<Todo> todos = new ArrayList<>();

    @BeforeEach
    void init(){
        todoService.todoRepository = todoRepository;
    }

    @BeforeAll
    public static void setup(){
        todos.add(new Todo(1L, "Ola test", "test on monday"));
        todos.add(new Todo(2L, "Picnic", "chills with friends"));
    }

    @Test
    void getAll() {
        Mockito.doReturn(todos)
                .when(todoRepository.findAll());

        final var response = todoService.getAll();

        assertEquals(response.size(), 2);
    }

}