import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:todo_flutter/controller/todo_controller.dart';

class CreateTodoScreen extends StatelessWidget {
  final TextEditingController nameController = TextEditingController();
  final TextEditingController descriptionController = TextEditingController();
  final TodoController todoController = Get.find();

  CreateTodoScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Create Todo'),
      ),
      body: Center(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Center(
                child: Text(
                  'Create Todo',
                  style: TextStyle(fontSize: 40),
                ),
              ),
              const SizedBox(height: 60),
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Form(
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
                      const SizedBox(height: 60),
                      ElevatedButton(
                        onPressed: () {
                          // Call the createTodo function with the new todo data
                          todoController.createTodo(
                            nameController.text,
                            descriptionController.text,
                          );
                        },
                        style: ElevatedButton.styleFrom(
                          textStyle: const TextStyle(fontSize: 20),
                          fixedSize: const Size(200, 50),
                        ),
                        child: const Text("Create"),
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
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
