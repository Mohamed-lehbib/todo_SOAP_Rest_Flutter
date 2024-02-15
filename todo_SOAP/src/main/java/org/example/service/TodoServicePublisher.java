package org.example.service;

import jakarta.xml.ws.Endpoint;
import org.example.dao.TodoDAOImpl;
import org.example.service.impl.TodoServiceImpl;

public class TodoServicePublisher {
    public static void main(String[] args) {
        String url = "http://localhost:3333/todoService";
        Endpoint.publish(url, new TodoServiceImpl(new TodoDAOImpl()));
        System.out.println("TodoService is published at " + url);
    }
}
