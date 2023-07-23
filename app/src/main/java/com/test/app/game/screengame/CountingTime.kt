package com.test.app.game.screengame

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CountingTime(navController: NavController, name: String) {
    BackHandler {
        navController.popBackStack()
    }
    val interactionSource = remember { MutableInteractionSource() }
    val number = remember { mutableStateOf(0) }
    val isChange = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .height(56.dp)
                .padding(8.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    isChange.value = 1
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Start",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Number: ${number.value}",
            fontWeight = FontWeight.Thin,
            fontSize = 32.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(22.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .height(56.dp)
                .padding(8.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    isChange.value = 0
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Stop",
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Button(
            onClick = { number.value = 0 },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green)
        ) {
            Text(
                text = "Reset",
                color = Color.Blue,
                fontWeight = FontWeight.W300,
                fontSize = 32.sp
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Row {
            Text("A", fontWeight = FontWeight.Light, fontSize = 22.sp)
            Text("B", fontWeight = FontWeight.ExtraLight, fontSize = 22.sp)
            Text("C", fontWeight = FontWeight.Normal, fontSize = 22.sp)
            Text("D", fontWeight = FontWeight.W900, fontSize = 22.sp)
            Text("E", fontWeight = FontWeight.Medium, fontSize = 22.sp)
            Text("F", fontWeight = FontWeight.W800, fontSize = 22.sp)
        }
    }
    if (isChange.value == 1 && name == "Nguyen") {
        number.value += 1
    }
}