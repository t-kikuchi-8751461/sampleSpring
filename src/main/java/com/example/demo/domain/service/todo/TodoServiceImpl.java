package com.example.demo.domain.service.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Todo;
import com.example.demo.mapper.TodoMapper;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoMapper todoMapper;

    @Override
    public void newTodo(String title, String details) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDetails(details);
        todo.setFinished(false);
        todoMapper.insert(todo);
    }

    @Override
    public List<Todo> todoList() {
        return todoMapper.selectAll();
    }

    @Override
    public void updateTodo(List<Todo> updateTodoList) {
        for (Todo todo : updateTodoList) {
            todoMapper.update(todo);
        }
    }

}
