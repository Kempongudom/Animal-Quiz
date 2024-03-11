package com.example.animalquiz

object Constrains {

    const val USER_NAME : String = "user_name"
    const val CORRECT_ANSWER : String = "correct_answer"
    const val TOTAL_QUESTION : String = "total_question"

    fun getQuestion() : ArrayList<Question>{

        val questionList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What animal this is ?",
            R.drawable.image_bird,
            "Cow",
            "Cat",
            "Dog",
            "bird",
            4
        )
        questionList.add(q1)

        val q2 = Question(
            2,
            "What animal is this ?",
            R.drawable.image_tiger,
            "Tiger",
            "Octopus",
            "Shark",
            "Dog",
            1
        )
        questionList.add(q2)

        val q3 = Question(
            3,
            "What animal is this ?",
            R.drawable.image_snake,
            "Lion",
            "Octopus",
            "Snake",
            "Cat",
            3
        )
        questionList.add(q3)

        val q4 = Question(
            4,
            "What animal is this ?",
            R.drawable.image_turtle,
            "Tiger",
            "turtle",
            "Shark",
            "Dog",
            2
        )
        questionList.add(q4)

        val q5 = Question(
            5,
            "What animal is this ?",
            R.drawable.image_duck,
            "Crocodile",
            "Shark",
            "Duck",
            "Cat",
            3
        )
        questionList.add(q5)

        val q6 = Question(
            6,
            "What animal is this ?",
            R.drawable.image_octopus,
            "Tiger",
            "Octopus",
            "Shark",
            "Dog",
            2
        )
        questionList.add(q6)

        val q7 = Question(
            7,
            "What animal is this ?",
            R.drawable.iamge_monkey,
            "Monkey",
            "Snake",
            "Shark",
            "Cow",
            1
        )
        questionList.add(q7)

        val q8 = Question(
            8,
            "What animal is this ?",
            R.drawable.image_lion,
            "Tiger",
            "Lion",
            "Snake",
            "Turtle",
            2
        )
        questionList.add(q8)

        val q9 = Question(
            9,
            "What animal is this ?",
            R.drawable.image_fish,
            "horse",
            "Cat",
            "Dog",
            "fish",
            4
        )
        questionList.add(q9)

        val q10 = Question(
            10,
            "What animal is this ?",
            R.drawable.image_horse,
            "Turtle",
            "Fish",
            "Horse",
            "Dog",
            3
        )
        questionList.add(q10)

        val q11 = Question(
            11,
            "What animal is this ?",
            R.drawable.image_mouse,
            "Cat",
            "Dog",
            "Mouse",
            "Shark",
            3
        )
        questionList.add(q11)

        val q12 = Question(
            12,
            "What animal is this ?",
            R.drawable.image_pig,
            "Tiger",
            "Cow",
            "Shark",
            "Pig",
            4
        )
        questionList.add(q12)

        val q13 = Question(
            13,
            "What animal is this ?",
            R.drawable.image_crocodile,
            "Fish",
            "Turtle",
            "Cow",
            "Crocodile",
            4
        )
        questionList.add(q13)

        val q14 = Question(
            14,
            "What animal is this ?",
            R.drawable.image_panda,
            "Tiger",
            "Octopus",
            "Panda",
            "Dog",
            3
        )
        questionList.add(q14)

        val q15 = Question(
            15,
            "What animal is this ?",
            R.drawable.image_cat,
            "Dog",
            "Mouse",
            "Goat",
            "Cat",
            4
        )
        questionList.add(q15)

        val q16 = Question(
            16,
            "What animal is this ?",
            R.drawable.image_dog,
            "Cat",
            "Dog",
            "Chicken",
            "Shark",
            2
        )
        questionList.add(q16)

        val q17 = Question(
            17,
            "What animal is this ?",
            R.drawable.image_goat,
            "Turtle",
            "Cow",
            "Goat",
            "Dog",
            3
        )
        questionList.add(q17)

        val q18 = Question(
            18,
            "What animal is this ?",
            R.drawable.image_goat,
            "Tiger",
            "Octopus",
            "Shark",
            "Cow",
            4
        )
        questionList.add(q18)

        val q19 = Question(
            19,
            "What animal is this ?",
            R.drawable.image_elephant,
            "Goat",
            "Turtle",
            "Chicken",
            "Elephant",
            4
        )
        questionList.add(q19)

        val q20 = Question(
            20,
            "What animal is this ?",
            R.drawable.image_panda,
            "Panda",
            "Octopus",
            "Shark",
            "Dog",
            1
        )
        questionList.add(q20)

        return questionList

    }


}