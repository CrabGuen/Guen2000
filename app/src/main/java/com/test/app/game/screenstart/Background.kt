package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.test.app.game.datalist.Question
import com.test.app.game.datalist.questionListTest

@Composable
fun BackGround(navController: NavController) {
    BackHandler {
        navController.navigate("about")
    }
    val stringList = ("tomato").toList()
    val numberList = (1..100).toList()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(stringList) { string ->
                Text("Item $string")
            }
        }
//        Spacer(modifier = Modifier.height(6.dp))
//        LazyColumn {
//            items(numberList) { number ->
//                Text("Number $number")
//            }
//        }
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
        item.options.forEach { option ->
            Text(text = option)
        }
    }
}
