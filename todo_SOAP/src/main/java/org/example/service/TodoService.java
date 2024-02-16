package org.example.service;

import jakarta.jws.WebService;
import org.example.model.Todo;
import java.util.List;

@WebService
public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);
    void addTodo(Todo todo);
    void updateTodo(Todo todo);
    void deleteTodo(Long id);
    void updateTodoStatus(Long id, boolean status);
}

