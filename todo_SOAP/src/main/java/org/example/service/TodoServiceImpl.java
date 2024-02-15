package org.example.service.impl;

import org.example.dao.TodoDAO;
import org.example.dao.TodoDAOImpl;
import org.example.model.Todo;
import org.example.service.TodoService;
import java.util.List;

public class TodoServiceImpl implements TodoService {

    private TodoDAO todoDAO;

    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    // Constructor injection of the DAO
    public TodoServiceImpl() {
        this.todoDAO = new TodoDAOImpl(); // Or use dependency injection if available
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoDAO.getAllTodos();
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoDAO.getTodoById(id);
    }

    @Override
    public void addTodo(Todo todo) {
        todoDAO.addTodo(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoDAO.updateTodo(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoDAO.deleteTodo(id);
    }

    @Override
    public void updateTodoStatusToTrue(Long id) {
        todoDAO.updateTodoStatusToTrue(id);
    }
}
