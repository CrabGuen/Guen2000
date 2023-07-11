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
fun ShowAnswersPScreen(navController: NavController, score: Int) {
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
                text = "How many types of Newton's laws are there?" +
                        "\n-> 3",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Current or voltage directly affect people?" +
                        "\n-> Current",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "What is gravity also called?" +
                        "\n-> Attraction force",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Symbol for frequency?" +
                        "\n-> f",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "When your hand grips the balloon string, what force is acting on the ball?" +
                        "\n-> Tension force",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Which quantity is responsible for obstructing the flow of electricity?" +
                        "\n-> Resistor",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Light is emitted from LEDs and lasers. What is the light?" +
                        "\n-> Color light",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "What is the natural light that we see every day?" +
                        "\n-> White light",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Symbols for acceleration, velocity, time?" +
                        "\n-> a, v, t",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "\"Give me a fulcrum and I will lift the earth\" is the saying of whom?" +
                        "\n-> Archimedes",
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