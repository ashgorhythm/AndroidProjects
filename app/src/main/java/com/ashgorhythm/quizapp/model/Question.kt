package com.ashgorhythm.quizapp.model

data class Question(
    val id: Int,
    val question: String,
    val flag: Int,
    val options: List<Option>,

)
data class Option(
    val text: String,
    val isCorrect: Boolean
)
