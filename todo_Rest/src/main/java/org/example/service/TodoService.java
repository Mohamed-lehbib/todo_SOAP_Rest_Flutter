package org.example.service;

import org.example.model.TodoModel;
import java.util.List;

public interface TodoService {
    List<TodoModel> getAllTodos();
    TodoModel getTodoById(Long id);
    void addTodo(TodoModel todo);
    void updateTodoStatus(Long id, boolean status);
    void updateTodo(TodoModel todo);
    void deleteTodo(Long id);
}

