package com.ashgorhythm.quizapp.model
import com.ashgorhythm.quizapp.R

object Questions {
    fun getQuestions(): MutableList<Question>{
        val question = mutableListOf<Question>()

        val q1 = Question(1,
            "Which country's flag is this?",
            R.drawable.bangladesh,
            listOf("India","Pakistan","Nepal","Bangladesh"),
            3)

    question.add(q1)
        return question
    }
}