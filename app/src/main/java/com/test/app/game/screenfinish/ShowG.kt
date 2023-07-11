package com.test.app.game.screenfinish

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ShowAnswersGScreen(navController: NavController, score: Int) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Show Answers",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Your score is $score/10",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(26.dp))
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "What is the longest river in Vietnam?" +
                        "\n-> Dong Nai River",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "How many provinces and cities are there in Vietnam?" +
                        "\n-> 63",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Where is Vung Tau located?" +
                        "\n-> Dong Nam Bo",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Where is the 17th parallel?" +
                        "\n-> Quang Tri",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Which province does the Truong Sa archipelago belong to?" +
                        "\n-> Khanh Hoa",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "What is the highest mountain in Vietnam?" +
                        "\n-> Fansipan Mountain",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Vietnam's largest city?" +
                        "\n-> TPHCM",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "How many natural heritages does Vietnam have recognized by UNESCO?" +
                        "\n-> 2",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Vietnam's largest cave?" +
                        "\n-> Son Doong",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Today's Cuu Long River has several gates leading to the sea?" +
                        "\n-> 7",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("field")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Next Field",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.Yellow
            )
        }
    }
}