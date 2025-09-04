package com.ashgorhythm.quizapp.model
import com.ashgorhythm.quizapp.R

object Questions {
    const val QUESTION = "Which country's flag is this?"
    fun getQuestions(): List<Question>{
        return listOf(
            Question(
                1,
                question = QUESTION,
                R.drawable.bangladesh,
                listOf(
                    Option("India",false),
                    Option("Nepal",false),
                    Option("Bangladesh",true),
                    Option("Pakistan",false)
                )
            ),
                    Question(
                    id = 2,
            question = QUESTION,
            flag = R.drawable.india,
            options = listOf(
                Option("India", true),
                Option("Sri Lanka", false),
                Option("Bangladesh", false),
                Option("Bhutan", false)
            )
        ),
        Question(
            id = 3,
            question = QUESTION,
            flag = R.drawable.pakistan,
            options = listOf(
                Option("Pakistan", true),
                Option("Afghanistan", false),
                Option("India", false),
                Option("Iran", false)
            )
        ),
        Question(
            id = 4,
            question = QUESTION,
            flag = R.drawable.nepal,
            options = listOf(
                Option("Nepal", true),
                Option("Bhutan", false),
                Option("Tibet", false),
                Option("Bangladesh", false)
            )
        ),
        Question(
            id = 5,
            question = QUESTION,
            flag = R.drawable.usa,
            options = listOf(
                Option("USA", true),
                Option("Canada", false),
                Option("UK", false),
                Option("Australia", false)
            )
        ),
        Question(
            id = 6,
            question = QUESTION,
            flag = R.drawable.uk,
            options = listOf(
                Option("UK", true),
                Option("Germany", false),
                Option("France", false),
                Option("Italy", false)
            )
        ),
        Question(
            id = 7,
            question = QUESTION,
            flag = R.drawable.france,
            options = listOf(
                Option("France", true),
                Option("Netherlands", false),
                Option("Italy", false),
                Option("Belgium", false)
            )
        ),
        Question(
            id = 8,
            question = QUESTION,
            flag = R.drawable.japan,
            options = listOf(
                Option("Japan", true),
                Option("China", false),
                Option("South Korea", false),
                Option("Vietnam", false)
            )
        ),
        Question(
            id = 9,
            question = QUESTION,
            flag = R.drawable.canada,
            options = listOf(
                Option("Canada", true),
                Option("USA", false),
                Option("Australia", false),
                Option("UK", false)
            )
        ),
            Question(
                id = 9,
                question = QUESTION,
                flag = R.drawable.saudi,
                options = listOf(
                    Option("Saudi", true),
                    Option("Qatar", false),
                    Option("Egypt", false),
                    Option("Turkey", false)
                )
            )
        )
    }
}