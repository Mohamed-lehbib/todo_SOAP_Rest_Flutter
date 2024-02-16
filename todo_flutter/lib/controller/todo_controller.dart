// TodoController.dart

import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:todo_flutter/model/todo.dart';
import 'package:todo_flutter/service/todo_service.dart';

class TodoController extends GetxController {
  RxBool isLoading = false.obs;
  RxList<Todo> todos = <Todo>[].obs;
  Rx<ThemeMode> themeMode = ThemeMode.light.obs;
  RxInt undoneCount = 0.obs;
  RxInt doneCount = 0.obs;

  final TodoService _todoService = TodoService();

  @override
  void onInit() {
    super.onInit();
    fetchData();
  }

  changeTheme(ThemeMode theme) {
    themeMode.value = theme;
    Get.changeThemeMode(theme);
  }

  Future<void> fetchData() async {
    isLoading(true);
    try {
      todos.assignAll(await _todoService.fetchTodos());
      final counts = await _todoService.getTodoCounts();
      undoneCount(counts['undoneCount'] ?? 0);
      doneCount(counts['doneCount'] ?? 0);
    } catch (e) {
      debugPrint('Error fetching todos: $e');
      // Display error message to user
      Get.snackbar('Error', 'Failed to fetch todos',
          snackPosition: SnackPosition.BOTTOM);
    } finally {
      isLoading(false);
    }
  }

  Future<void> deleteTodo(int id) async {
    try {
      await _todoService.deleteTodo(id);
      fetchData();
    } catch (e) {
      debugPrint('Error deleting todo: $e');
      // Display error message to user
      Get.snackbar('Error', 'Failed to delete todo',
          snackPosition: SnackPosition.BOTTOM);
    }
  }

  Future<void> updateTodoStatus(int id, bool completed) async {
    try {
      await _todoService.updateTodoStatus(id, completed);
      fetchData();
    } catch (e) {
      debugPrint('Error updating todo status: $e');
      // Display error message to user
      Get.snackbar('Error', 'Failed to update todo status',
          snackPosition: SnackPosition.BOTTOM);
    }
  }

  Future<void> editTodo(int id, Todo updatedTodo) async {
    try {
      await _todoService.editTodo(id, updatedTodo);
      Get.back();
      fetchData();
    } catch (e) {
      debugPrint('Error editing todo: $e');
      // Display error message to user
      Get.snackbar('Error', 'Failed to edit todo',
          snackPosition: SnackPosition.BOTTOM);
    }
  }

  Future<void> createTodo(String title, String description) async {
    try {
      await _todoService.createTodo(title, description);
      Get.back();
      fetchData();
    } catch (e) {
      debugPrint('Error creating todo: $e');
      Get.snackbar('Error', 'Failed to create todo',
          snackPosition: SnackPosition.BOTTOM);
    }
  }
}
