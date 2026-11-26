package com.example.triviatv

data class Question(
    val id: Int,
    val category: String,
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int
)
