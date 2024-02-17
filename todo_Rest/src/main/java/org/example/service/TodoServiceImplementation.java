package org.example.service;

import org.example.model.TodoModel;
import org.example.soapclient.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TodoServiceImplementation implements TodoService {
    private TodoServiceImpl port;

    public TodoServiceImplementation() {
        try {
            URL wsdlLocation = new URL("http://localhost:3334/todoService?wsdl");
            TodoServiceImplService service = new TodoServiceImplService(wsdlLocation);
            port = service.getTodoServiceImplPort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TodoModel> getAllTodos() {
        List<TodoModel> todos = new ArrayList<>();
        List<Todo> todoList = port.getAllTodos(); // Directly receive the list of todos
        if (todoList != null) { // Check if the list is not null
            for (Todo todo : todoList) { // Iterate over the returned list
                todos.add(mapToTodoModel(todo)); // Convert and add to the list of TodoModel
            }
        }
        return todos;
    }


    @Override
    public TodoModel getTodoById(Long id) {
        // Directly pass the ID to the getTodoById method
        Todo todo = port.getTodoById(id);
        // Check if todo is not null before mapping
        if (todo != null) {
            return mapToTodoModel(todo);
        }
        return null;
    }

    @Override
    public void addTodo(TodoModel todoModel) {
        // Convert your model to the SOAP Todo object
        Todo todo = mapToTodoType(todoModel);
        // Directly pass the Todo object to the addTodo method
        port.addTodo(todo);
    }

    @Override
    public void updateTodoStatus(Long id, boolean status) {
        // Pass the individual arguments to the updateTodoStatus method
        port.updateTodoStatus(id, status);
    }

    @Override
    public void updateTodo(TodoModel todoModel) {
        Todo todo = mapToTodoType(todoModel); // Convert TodoModel to Todo
        port.updateTodo(todo); // Pass Todo object to the updateTodo method
    }

    @Override
    public void deleteTodo(Long id) {
        port.deleteTodo(id);
    }


    private TodoModel mapToTodoModel(Todo todo) {
        TodoModel model = new TodoModel();
        model.setId(todo.getId());
        model.setName(todo.getName());
        model.setDescription(todo.getDescription());
        model.setStatus(todo.isStatus());
        return model;
    }

    private Todo mapToTodoType(TodoModel model) {
        Todo todo = new Todo();
        todo.setId(model.getId());
        todo.setName(model.getName());
        todo.setDescription(model.getDescription());
        todo.setStatus(model.isStatus());
        return todo;
    }
}
