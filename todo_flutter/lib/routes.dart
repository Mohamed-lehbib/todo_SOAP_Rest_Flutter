import 'package:get/get.dart';
import 'package:todo_flutter/view/create_todo_screen.dart';
import 'package:todo_flutter/view/edit_screen.dart';
import 'package:todo_flutter/view/home_screen.dart';

final routes = [
  GetPage(name: '/', page: () => HomeScreen()),
  GetPage(name: '/edit', page: () => EditTodoScreen()),
  GetPage(name: '/create', page: () => CreateTodoScreen()),
];
