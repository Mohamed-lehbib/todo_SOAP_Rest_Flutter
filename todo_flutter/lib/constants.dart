import 'package:flutter/material.dart';

final ThemeData lightTheme = ThemeData(
  useMaterial3: true, // Activer Material 3
  brightness: Brightness.light,
  colorScheme: ColorScheme.fromSeed(
    seedColor: Colors.blue, // Couleur de base pour le thème clair
    secondary: Colors.white,
  ),
  appBarTheme: const AppBarTheme(
    backgroundColor: Colors.white, // Couleur de fond de l'AppBar
    titleTextStyle: TextStyle(
        color: Colors.black,
        fontSize: 20,
        fontWeight: FontWeight.bold), // Style de texte pour l'AppBar
    elevation: 0, // Supprimer l'ombre de l'AppBar
  ),
  textButtonTheme: TextButtonThemeData(
    style: TextButton.styleFrom(
      foregroundColor: Colors.black, // Couleur du texte pour les boutons
    ),
  ),
  // Autres personnalisations...
);

final ThemeData darkTheme = ThemeData(
  useMaterial3: true, // Activer Material 3
  brightness: Brightness.dark,
  colorScheme: ColorScheme.fromSeed(
    seedColor: Colors.blue, // Couleur de base pour le thème sombre
    brightness: Brightness.dark,
  ),
  appBarTheme: AppBarTheme(
    backgroundColor:
        Colors.grey[900], // Couleur de fond plus sombre pour l'AppBar
    titleTextStyle: const TextStyle(
        color: Colors.white,
        fontSize: 20,
        fontWeight:
            FontWeight.bold), // Texte clair pour le contraste en mode sombre
    elevation: 0, // Supprimer l'ombre de l'AppBar
  ),
  textButtonTheme: TextButtonThemeData(
    style: TextButton.styleFrom(
      foregroundColor:
          Colors.white, // Couleur du texte adaptée pour le mode sombre
    ),
  ),
  // Autres personnalisations pour le mode sombre...
);
