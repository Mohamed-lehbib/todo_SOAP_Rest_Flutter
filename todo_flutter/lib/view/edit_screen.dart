import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:todo_flutter/controller/todo_controller.dart';
import 'package:todo_flutter/model/todo.dart';

// ignore: must_be_immutable
class EditTodoScreen extends StatelessWidget {
  final TextEditingController nameController = TextEditingController();
  final TextEditingController descriptionController = TextEditingController();
  TodoController todoController = Get.find();

  EditTodoScreen({super.key});

  @override
  Widget build(BuildContext context) {
    // Get the arguments passed from the previous screen
    final Todo todo = Get.arguments;

    // Set the initial values of the controllers
    nameController.text = todo.title;
    descriptionController.text = todo.description;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Edit Todo'),
      ),
      body: Center(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Center(
                child: Text(
                  'Edit Todo',
                  style: TextStyle(fontSize: 40),
                ),
              ),
              const SizedBox(height: 40),
              Form(
                child: Column(
                  children: [
                    TextField(
                      controller: nameController,
                      decoration: const InputDecoration(
                        labelText: "Name",
                        hintText: "Enter Todo Name",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(20)),
                        ),
                      ),
                    ),
                    const SizedBox(height: 20),
                    TextField(
                      controller: descriptionController,
                      maxLines: 3,
                      decoration: const InputDecoration(
                        labelText: "Description",
                        hintText: "Enter Todo Description",
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(20)),
                        ),
                      ),
                    ),
                    const SizedBox(height: 20),
                    ElevatedButton(
                      onPressed: () {
                        // Call the editTodo function with the ID and the todo
                        todoController.editTodo(
                            todo.id,
                            Todo(
                              id: todo.id,
                              title: nameController.text,
                              description: descriptionController.text,
                              completed: todo.completed,
                            ));
                      },
                      style: ElevatedButton.styleFrom(
                        textStyle: const TextStyle(fontSize: 20),
                        fixedSize: const Size(200, 50),
                      ),
                      child: const Text("Update"),
                    ),
                    const SizedBox(height: 20),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        TextButton(
                          onPressed: () {
                            Get.back();
                          },
                          child: const Text(
                            "Cancel",
                            style: TextStyle(fontWeight: FontWeight.bold),
                          ),
                        )
                      ],
                    )
                  ],
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
