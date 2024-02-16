package org.example.service;

import org.example.model.TodoModel;
import org.example.soapclient.*;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TodoServiceImplementation implements TodoService {
    private TodoServiceImpl port;

    public TodoServiceImplementation() {
        try {
            // Assuming TodoServiceImplService is generated from the WSDL
            URL wsdlLocation = new URL("http://localhost:3334/todoService?wsdl");
            QName qname = new QName("http://service.example.org/", "TodoServiceImplService");
            TodoServiceImplService service = new TodoServiceImplService(wsdlLocation, qname);
            port = service.getTodoServiceImplPort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TodoModel> getAllTodos() {
        List<TodoModel> todos = new ArrayList<>();
        // Call the SOAP method, assuming direct invocation returns the response
        GetAllTodosResponse response = port.getAllTodos();
        for (Todo todo : response.getTodo()) {
            todos.add(mapToTodoModel(todo));
        }
        return todos;
    }

    @Override
    public TodoModel getTodoById(Long id) {
        // Prepare the request
        GetTodoById request = new GetTodoById();
        request.setId(id);
        // Call the SOAP service
        GetTodoByIdResponse response = port.getTodoById(request);
        // Assuming response has a single Todo object
        return mapToTodoModel(response.getTodo());
    }

    @Override
    public void addTodo(TodoModel todoModel) {
        // Prepare the request
        AddTodo request = new AddTodo();
        Todo todo = mapToTodoType(todoModel);
        request.setTodo(todo);
        // Call the SOAP service
        port.addTodo(request);
    }

    @Override
    public void updateTodoStatus(Long id, boolean status) {
        // Prepare the request
        UpdateTodoStatus request = new UpdateTodoStatus();
        request.setId(id);
        request.setStatus(status);
        // Call the SOAP service
        port.updateTodoStatus(request);
    }

    @Override
    public void updateTodo(TodoModel todoModel) {
        // Prepare the request
        UpdateTodo request = new UpdateTodo();
        Todo todo = mapToTodoType(todoModel);
        request.setTodo(todo);
        // Call the SOAP service
        port.updateTodo(request);
    }

    @Override
    public void deleteTodo(Long id) {
        // Prepare the request
        DeleteTodo request = new DeleteTodo();
        request.setId(id);
        // Call the SOAP service
        port.deleteTodo(request);
    }

    // Utility method to convert SOAP client's Todo to TodoModel
    private TodoModel mapToTodoModel(Todo todoType) {
        TodoModel todo = new TodoModel();
        todo.setId(todoType.getId());
        todo.setName(todoType.getName());
        todo.setDescription(todoType.getDescription());
        todo.setStatus(todoType.isStatus());
        return todo;
    }

    // Utility method to convert TodoModel to SOAP client's Todo for requests
    private Todo mapToTodoType(TodoModel todoModel) {
        Todo todo = new Todo();
        todo.setId(todoModel.getId());
        todo.setName(todoModel.getName());
        todo.setDescription(todoModel.getDescription());
        todo.setStatus(todoModel.isStatus());
        return todo;
    }
}
