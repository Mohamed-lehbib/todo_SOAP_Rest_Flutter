import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:todo_flutter/constants.dart';
import 'package:todo_flutter/routes.dart';

void main() {
  runApp(const Main());
}

class Main extends StatelessWidget {
  const Main({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      themeMode: ThemeMode.light,
      debugShowCheckedModeBanner: false,
      getPages: routes,
      theme: lightTheme,
      darkTheme: darkTheme,
    );
  }
}
