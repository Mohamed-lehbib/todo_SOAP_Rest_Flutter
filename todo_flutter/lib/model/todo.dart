class Todo {
  final int id;
  final String title;
  final String description;
  final bool completed;

  Todo({
    required this.id,
    required this.title,
    required this.description,
    required this.completed,
  });

  factory Todo.fromJson(Map<String, dynamic> json) {
    return Todo(
      id: json['id'] as int,
      title: json['name'] as String,
      description: json['description'] as String,
      completed: json['status'] as bool, // Parse 'status' field as a boolean
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'name': title,
      'description': description,
      'status': completed,
    };
  }
}
