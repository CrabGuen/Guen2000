package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.app.game.R

@Composable
fun DiceRoller(navController: NavController, name: String) {
    BackHandler {
        navController.popBackStack()
    }
    val interactionSource = remember { MutableInteractionSource() }

    var result by remember { mutableStateOf(1) }

    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
        Button(
            onClick = { result = (1..6).random() }
        ) {
            Text(stringResource(R.string.roll), color = Color.Blue)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("time/${name}")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Counting Time",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Name: $name",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.Blue
        )
    }
}