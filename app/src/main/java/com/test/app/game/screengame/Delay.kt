package com.test.app.game.screengame

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text

@Composable
fun DelayScreen(navController: NavController) {
    BackHandler {
        navController.popBackStack()
    }
    val questions = listOf(
        Question(
            "Ai là nhà phát minh đèn đốt xăng?",
            listOf("Thomas Edison", "Nikola Tesla", "Alexander Graham Bell", "Benjamin Franklin"),
            0
        ),
        Question(
            "Đất nước nào được gọi là \"đất nụ cười\"?",
            listOf("Nhật Bản", "Canada", "Thụy Điển", "Ấn Độ"),
            1
        ),
        Question(
            "Ai là tác giả cuốn tiểu thuyết \"Harry Potter\"?",
            listOf("J.K. Rowling", "Stephen King", "George Orwell", "Mark Twain"),
            0
        )
    )
    LaunchedEffect(Unit) {
        questions.forEach { question ->
            delay(3000)
//            QuestionItem(question)
        }
    }
}
@Composable
fun QuestionItem(item: Question) {
    Column {
        Text(text = item.question)
        item.answers.forEach { answer ->
            Text(text = answer)
        }
    }
}
data class Question(val question: String, val answers: List<String>, val index: Int)
