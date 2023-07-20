package com.test.app.game.screengame

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondTestScreen(navController: NavController, name: String) {

    BackHandler {
        navController.navigate("menu")
    }
    val number = remember { mutableStateOf(0) }
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your name: $name",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { number.value += 1 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("1")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = { number.value += 2 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("2")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = { number.value += 3 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("3")
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { number.value += 4 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("4")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = { number.value += 5 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("5")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = { number.value += 6 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("6")
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { number.value += 7 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("7")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = { number.value += 8 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("8")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = { number.value += 9 },
                modifier = Modifier
                    .height(42.dp)
                    .width(42.dp)
                    .background(color = Color.Green)
            ) {
                Text("9")
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Button(
            onClick = { number.value += 0 },
            modifier = Modifier
                .height(42.dp)
                .width(42.dp)
                .background(color = Color.Green)
        ) {
            Text("0")
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Number: ${number.value}",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(6.dp))
        Button(
            onClick = { number.value = 0 },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green)
        ) {
            Text("Reset Number")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("tip")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tip Time Screen",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("image")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Affirmation Screen",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Cyan, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("topic")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Topic Screen",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
