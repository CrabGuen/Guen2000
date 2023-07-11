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
fun ShowAnswersHScreen(navController: NavController, score: Int) {
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
                text = "Who is the founder and first leader of the Democratic Republic of Vietnam?" +
                        "\n-> Ho Chi Minh",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "How long did the Vietnam War last?" +
                        "\n-> 1955 to 1975",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Since when is Ha Noi the capital of Viet Nam?" +
                        "\n-> Since 1976",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "6/12/1953, what event happened?" +
                        "\n-> Battle of Dien Bien Phu",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who is the commander of the Dien Bien Phu campaign?" +
                        "\n-> Vo Nguyen Giap",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who planted the flag on the roof of the Dinh Doc Lap?" +
                        "\n-> Bui Quang Than",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who wrote Vietnam's first declaration of independence?" +
                        "\n-> Ly Thuong Kiet",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who wrote Binh Ngo Dai Cao?" +
                        "\n-> Nguyen Trai",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "How many declarations of independence does Vietnam have?" +
                        "\n-> 3",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "When was President Ho Chi Minh born?" +
                        "\n-> 19/5/1890",
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