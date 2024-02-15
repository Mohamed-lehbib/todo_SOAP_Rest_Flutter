-- Create the database
CREATE DATABASE todo_db;

-- Connect to the database
\c todo_db;

-- Create the table for todos
CREATE TABLE todos (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    status BOOLEAN NOT NULL DEFAULT FALSE
);
