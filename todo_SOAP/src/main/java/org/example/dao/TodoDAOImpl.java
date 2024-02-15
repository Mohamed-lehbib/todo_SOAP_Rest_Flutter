package org.example.dao;

import org.example.db.DbConnection;
import org.example.model.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOImpl implements TodoDAO {

    private Connection connection;

    public TodoDAOImpl() {
        try {
            connection = DbConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                todos.add(mapTodoFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    @Override
    public Todo getTodoById(Long id) {
        String sql = "SELECT * FROM todos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapTodoFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addTodo(Todo todo) {
        String sql = "INSERT INTO todos (name, description, status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, todo.getName());
            statement.setString(2, todo.getDescription());
            statement.setBoolean(3, todo.getStatus());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                todo.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Creating todo failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTodo(Todo todo) {
        String sql = "UPDATE todos SET name = ?, description = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todo.getName());
            statement.setString(2, todo.getDescription());
            statement.setBoolean(3, todo.getStatus());
            statement.setLong(4, todo.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTodo(Long id) {
        String sql = "DELETE FROM todos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTodoStatusToTrue(Long id) {
        String sql = "UPDATE todos SET status = TRUE WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Todo mapTodoFromResultSet(ResultSet resultSet) throws SQLException {
        Todo todo = new Todo();
        todo.setId(resultSet.getLong("id"));
        todo.setName(resultSet.getString("name"));
        todo.setDescription(resultSet.getString("description"));
        todo.setStatus(resultSet.getBoolean("status"));
        return todo;
    }
}

