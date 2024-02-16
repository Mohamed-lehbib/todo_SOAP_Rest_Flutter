package org.example.controller;

import org.example.model.TodoModel;
import org.example.service.TodoServiceImplementation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/todos")
public class TodoController {

    private final TodoServiceImplementation todoService = new TodoServiceImplementation();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTodos() {
        List<TodoModel> todos = todoService.getAllTodos();
        return Response.ok(todos).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodoById(@PathParam("id") Long id) {
        TodoModel todo = todoService.getTodoById(id);
        if (todo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(todo).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTodo(TodoModel todoModel) {
        todoService.addTodo(todoModel);
        return Response.status(Response.Status.CREATED).entity(todoModel).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTodo(@PathParam("id") Long id, TodoModel todoModel) {
        TodoModel existingTodo = todoService.getTodoById(id);
        if (existingTodo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        todoModel.setId(id); // Ensure the ID is set correctly
        todoService.updateTodo(todoModel);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}/status")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTodoStatus(@PathParam("id") Long id, boolean status) {
        TodoModel existingTodo = todoService.getTodoById(id);
        if (existingTodo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        todoService.updateTodoStatus(id, status);
        return Response.ok().build();
    }



    @DELETE
    @Path("/{id}")
    public Response deleteTodo(@PathParam("id") Long id) {
        TodoModel todo = todoService.getTodoById(id);
        if (todo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        todoService.deleteTodo(id);
        return Response.ok().build();
    }
}

