package com.ashgorhythm.quizapp.model
import com.ashgorhythm.quizapp.R

object Questions {
    fun getQuestions(): List<Question>{
        return listOf(
            Question(
                1,
                "Which country's flag is this?",
                R.drawable.bangladesh,
                listOf(
                    Option("India",false),
                    Option("Nepal",false),
                    Option("Bangladesh",true),
                    Option("Pakistan",false)
                )
            )
        )
    }
}