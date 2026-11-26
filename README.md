# 🎮 TRIVIA TV 📺

**TRIVIA TV** es un videojuego de preguntas y respuestas (trivia) desarrollado de manera nativa para **Android TV** y **Google TV**. Es una aplicación completa, moderna, visualmente atractiva y diseñada específicamente para la experiencia de la sala de estar con control remoto.

---

## 🚀 Características Principales

- **Optimizado para Smart TV**: Navegación fluida mediante el control remoto (D-pad), botones con estados de foco visibles y soporte para el lanzador Leanback.
- **5 Categorías de Juego**: 
  - 🌍 Cultura General
  - 🔬 Ciencia
  - 💻 Tecnología
  - ⚽ Deportes
  - 🎬 Entretenimiento
- **Dinámica de Juego Real**:
  - Preguntas y 4 respuestas posibles (5 preguntas por categoría almacenadas localmente).
  - Temporizador de **15 segundos** por pregunta con cuenta regresiva.
  - Asignación de 100 puntos por respuesta correcta.
  - Retroalimentación visual instantánea (verde/rojo) y avance automático.
- **Persistencia de Puntuación**: Guardado automático de la mejor puntuación utilizando `SharedPreferences`.
- **Diseño Visual Moderno**: Estética de videojuego con fondos oscuros, acentos en morado, violeta y azul eléctrico, y tarjetas con esquinas redondeadas.
- **Sin Dependencias Externas**: Funciona 100% de manera local, sin requerir Firebase, servidores ni APIs de terceros.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **Plataforma**: Android nativo (Android TV / Google TV)
- **Interfaces**: XML Layouts (`ConstraintLayout`, `CardView`, `MaterialComponents`) con **ViewBinding**.
- **Almacenamiento**: `SharedPreferences`
- **Control de Tiempos**: `CountDownTimer`

---

## 📂 Estructura del Proyecto

- `MainActivity.kt`: Pantalla de inicio con el título, subtítulo, mejor puntuación y botones de navegación.
- `CategoriesActivity.kt`: Pantalla de selección de las 5 categorías de trivia.
- `GameActivity.kt`: Pantalla del juego principal, manejo de preguntas, temporizador y validación.
- `ResultActivity.kt`: Pantalla de resultados, resumen de aciertos/errores y actualización de récord.
- `InstructionsActivity.kt`: Guía de uso y navegación con el control remoto.
- `TriviaRepository.kt`: Repositorio local de preguntas y respuestas.

---

## 📦 Archivo Ejecutable (APK)

El archivo APK compilado para pruebas y depuración se encuentra en la siguiente ruta del proyecto:
`app/build/outputs/apk/debug/app-debug.apk`

---

## 👨‍💻 Autor
Proyecto escolar desarrollado para Pantallas Inteligentes / Android TV.
