import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:todo_flutter/controller/todo_controller.dart';
import 'package:todo_flutter/model/todo.dart';

class HomeScreen extends StatelessWidget {
  final TodoController todoController = Get.put(TodoController());

  HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: Obx(
            () => Icon(todoController.themeMode.value == ThemeMode.dark
                ? Icons.dark_mode
                : Icons.light_mode),
          ),
          onPressed: () {
            todoController.changeTheme(
                todoController.themeMode.value == ThemeMode.dark
                    ? ThemeMode.light
                    : ThemeMode.dark);
          },
        ),
        title: const Text('To-Do'),
      ),
      body: Column(
        children: [
          Card(
            margin: const EdgeInsets.symmetric(horizontal: 16.0),
            child: Padding(
              padding: const EdgeInsets.all(40.0),
              child: Column(
                children: [
                  const Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Text(
                        'Done',
                        style: TextStyle(fontSize: 20),
                      ),
                      Text('UnDone', style: TextStyle(fontSize: 20)),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Obx(() => Text(
                            todoController.doneCount.value.toString(),
                            style: const TextStyle(
                                color: Colors.green, fontSize: 30),
                          )),
                      Obx(() => Text(
                            todoController.undoneCount.value.toString(),
                            style: const TextStyle(
                                color: Colors.red, fontSize: 30),
                          )),
                    ],
                  ),
                ],
              ),
            ),
          ),
          Expanded(
            child: Obx(() {
              if (todoController.isLoading.value) {
                return const Center(child: CircularProgressIndicator());
              } else {
                return RefreshIndicator(
                  onRefresh: () async {
                    todoController.fetchData();
                  },
                  child: ListView.builder(
                    itemCount: todoController.todos.length,
                    itemBuilder: (context, index) {
                      Todo todo = todoController.todos[index];
                      return Dismissible(
                        key: UniqueKey(),
                        direction: DismissDirection.horizontal,
                        background: Container(
                          color: Colors.red,
                          alignment: Alignment.centerLeft,
                          padding: const EdgeInsets.only(left: 20.0),
                          child: const Icon(Icons.delete, color: Colors.white),
                        ),
                        secondaryBackground: Container(
                          color: Colors.green,
                          alignment: Alignment.centerRight,
                          padding: const EdgeInsets.only(right: 20.0),
                          child: const Icon(Icons.edit, color: Colors.white),
                        ),
                        onDismissed: (direction) {
                          if (direction == DismissDirection.startToEnd) {
                            // Delete action
                            todoController.deleteTodo(todo.id);
                          } else if (direction == DismissDirection.endToStart) {
                            // Modify action
                            // Navigate to edit screen or show a dialog
                            Get.toNamed('/edit', arguments: todo);
                          }
                        },
                        child: ListTile(
                          title: Text(todo.title),
                          subtitle: Text(todo.description),
                          leading: Checkbox(
                            value: todo.completed,
                            onChanged: (value) => todoController
                                .updateTodoStatus(todo.id, value!),
                          ),
                        ),
                      );
                    },
                  ),
                );
              }
            }),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Get.toNamed('/create');
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
