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
fun ShowAnswersAScreen(navController: NavController, score: Int) {
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
                text = "What is the mission of the FBI?" +
                        "\n-> Intelligence in the US",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "What is the mission of the CIA?" +
                        "\n-> Intelligence outside the US",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Whose headquarters is area 51?" +
                        "\n-> USAF (United States Air Force)",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who is allowed to print USD?" +
                        "\n-> FED (Federal Reserve System)",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who has the right to legislate?" +
                        "\n-> Parliament",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who has the right to executive?" +
                        "\n-> President",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Who has the right to justice?" +
                        "\n-> Supreme court",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Where is the parliament headquarters?" +
                        "\n-> Washington D.C",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Where does terrain SEAL work?" +
                        "\n-> Sea, Air and Land",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "NOC is the name of which organization?" +
                        "\n-> NOC (Non Official Cover) -> CIA",
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