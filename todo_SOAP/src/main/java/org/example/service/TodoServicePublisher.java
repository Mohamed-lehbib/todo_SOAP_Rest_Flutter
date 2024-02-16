package org.example.service;

import jakarta.xml.ws.Endpoint;
import org.example.dao.TodoDAOImpl;
import org.example.service.TodoServiceImpl;

public class TodoServicePublisher {
    public static void main(String[] args) {
        String url = "http://localhost:3334/todoService";
        Endpoint.publish(url, new TodoServiceImpl());
        System.out.println("TodoService is published at " + url);
    }
}
