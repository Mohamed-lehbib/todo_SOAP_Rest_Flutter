package org.example;

import org.example.controller.TodoController;
import org.example.service.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.example.service.TodoServiceImplementation;

import java.net.URI;

public class App {
    public static void main(String[] args) {
        URI baseUri = URI.create("http://localhost:3333/");
        ResourceConfig config = new ResourceConfig();
        config.register(TodoController.class); // Register TodoController
        config.register(JacksonFeature.class); // Register JacksonFeature
        config.register(CORSFilter.class);
        GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        System.out.println("Jersey app started at " + baseUri);
    }
}
