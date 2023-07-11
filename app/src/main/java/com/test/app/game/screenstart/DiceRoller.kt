package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.test.app.game.R

@Composable
fun DiceRoller(navController: NavController) {
    BackHandler {
        navController.popBackStack()
    }
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
        Button(
            onClick = { result = (1..6).random() }
        ) {
            Text(stringResource(R.string.roll))
        }
    }
}