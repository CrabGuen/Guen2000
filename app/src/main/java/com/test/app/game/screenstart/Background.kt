package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.app.game.datalist.Question
import com.test.app.game.datalist.questionListTest

@Composable
fun BackGround(navController: NavController) {
    BackHandler {
        navController.popBackStack()
    }
    val stringList = ("tomato").toList()
//    val numberList = (1..100).toList()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(stringList) { string ->
                Text("Item $string")
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        LazyColumn {
            items(questionListTest) { ques ->
                Question(ques)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun Question(item: Question) {
    Column {
        Text(text = item.question)
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            item.options.forEach { option ->
                Text(
                    text = option,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}
