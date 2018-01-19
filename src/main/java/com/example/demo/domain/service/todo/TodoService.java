package com.example.demo.domain.service.todo;

import java.util.List;

import com.example.demo.domain.model.Todo;

public interface TodoService {

    List<Todo> todoList();

    void newTodo(String title, String details);

    void updateTodo(List<Todo> updateTodoList);
}
