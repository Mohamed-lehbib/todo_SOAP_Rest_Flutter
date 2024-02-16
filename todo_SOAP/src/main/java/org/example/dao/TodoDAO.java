package org.example.dao;

import org.example.model.Todo;

import java.util.List;

public interface TodoDAO {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);
    void addTodo(Todo todo);
    void updateTodo(Todo todo);
    void deleteTodo(Long id);
    void updateTodoStatus(Long id, boolean status);
}
