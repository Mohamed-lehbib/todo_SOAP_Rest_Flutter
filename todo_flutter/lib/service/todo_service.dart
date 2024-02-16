import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:todo_flutter/model/todo.dart';

class TodoService {
  final String baseUrl =
      'https://534f-41-188-106-66.ngrok-free.app'; // Include API endpoint path

  Future<List<Todo>> fetchTodos() async {
    final response = await http.get(Uri.parse('$baseUrl/todos'));
    if (response.statusCode == 200) {
      final responseBody = response.body;
      // print('Response body: $responseBody'); // Add this line for logging
      if (responseBody.isNotEmpty) {
        Iterable list = json.decode(responseBody);
        List<Todo> todos = list.map((model) => Todo.fromJson(model)).toList();

        // Sort the todos with not done todos first
        todos.sort((a, b) {
          if (a.completed && !b.completed) {
            return 1;
          } else if (!a.completed && b.completed) {
            return -1;
          } else {
            return 0;
          }
        });

        return todos;
      } else {
        throw Exception('Response body is empty or null');
      }
    } else {
      throw Exception('Failed to fetch todos: ${response.statusCode}');
    }
  }

  Future<void> deleteTodo(int id) async {
    try {
      final response = await http.delete(Uri.parse('$baseUrl/todos/$id'));
      if (response.statusCode != 200) {
        throw Exception('Failed to delete todo: ${response.statusCode}');
      }
    } catch (e) {
      throw Exception('Failed to delete todo: $e');
    }
  }

  Future<void> updateTodoStatus(int id, bool completed) async {
    try {
      final response = await http.put(
        Uri.parse('$baseUrl/todos/$id/status'),
        headers: <String, String>{'Content-Type': 'application/json'},
        body: '$completed',
      );
      if (response.statusCode != 200) {
        throw Exception('Failed to update todo status: ${response.statusCode}');
      }
    } catch (e) {
      throw Exception('Failed to update todo status: $e');
    }
  }

  Future<Map<String, int>> getTodoCounts() async {
    try {
      final todos = await fetchTodos();
      int undoneCount = todos.where((todo) => !todo.completed).length;
      int doneCount = todos.where((todo) => todo.completed).length;
      return {'undoneCount': undoneCount, 'doneCount': doneCount};
    } catch (e) {
      throw Exception('Failed to get todo counts: $e');
    }
  }

  Future<void> editTodo(int id, Todo updatedTodo) async {
    // print(updatedTodo.toJson());
    try {
      final response = await http.put(
        Uri.parse('$baseUrl/todos/$id'),
        headers: <String, String>{'Content-Type': 'application/json'},
        body: jsonEncode(updatedTodo.toJson()),
      );
      if (response.statusCode != 200) {
        throw Exception('Failed to edit todo: ${response.statusCode}');
      }
    } catch (e) {
      throw Exception('Failed to edit todo: $e');
    }
  }

  Future<void> createTodo(String title, String description) async {
    try {
      final response = await http.post(
        Uri.parse('$baseUrl/todos'),
        headers: <String, String>{'Content-Type': 'application/json'},
        body: jsonEncode(
            {'name': title, 'description': description, 'status': false}),
      );
      if (response.statusCode != 201) {
        throw Exception('Failed to create todo: ${response.statusCode}');
      }
    } catch (e) {
      throw Exception('Failed to create todo: $e');
    }
  }
}
