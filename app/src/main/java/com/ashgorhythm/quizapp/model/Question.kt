package com.ashgorhythm.quizapp.model

data class Question(
    val id: Int,
    val question: String,
    val flag: Int,
    val options: List<String>,
    val correctAnswer: Int
)
