package com.test.app.game.datalist

fun getRandomUniqueQuestions(category: String): List<Question>? {

    val questionList = when (category) {
        Category.MATH -> questionListM
        Category.HISTORY -> questionListH
        Category.CHEMISTRY -> questionListC
        Category.GEOGRAPHY -> questionListG
        Category.PHYSICS -> questionListP
        Category.LITERATURE -> questionListL
        Category.AMERICAN -> questionListA
        Category.WORLD -> questionListW
        else -> questionListM
    }
    val randomQuestion = questionList.subList(0, 10).shuffled()
    val lastQuestion = questionList.last()
    return randomQuestion + lastQuestion
}

