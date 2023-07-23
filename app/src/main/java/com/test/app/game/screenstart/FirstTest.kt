package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.test.app.game.R

@Composable
fun FirstTestScreen(navController: NavController) {

    BackHandler {
        navController.popBackStack()
    }
    val interactionSource = remember { MutableInteractionSource() }

    val name = remember { mutableStateOf("") }
    var textColor by remember { mutableStateOf(Color.Red) }
    val focusManager = LocalFocusManager.current

    val firstNumberInput = remember { mutableStateOf("0") }
    val firstNumber = firstNumberInput.value.toDoubleOrNull() ?: 0.0
    val secondNumberInput = remember { mutableStateOf("0") }
    val secondNumber = secondNumberInput.value.toDoubleOrNull() ?: 0.0
    val operator = remember { mutableStateOf("") }

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            modifier = Modifier
                .requiredHeight(80.dp)
                .fillMaxWidth(),
            contentDescription = "My Image",
            contentScale = ContentScale.Crop
        )
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Enter your data") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus(true)}
            )
        )
        // Điều kiện đổi màu của Text
        textColor = if (name.value == "Nguyen") {
            Color.Blue
        } else {
            Color.Red
        }
        Spacer(modifier = Modifier.height(6.dp))
        Button(
            onClick = {
                navController.navigate("second/${name.value}")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(color = Color.Blue)
        ) {
            Text(
                text = "Go to Second Screen",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = firstNumberInput.value,
            onValueChange = { firstNumberInput.value = it },
            label = { Text(text = "First Number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = operator.value,
            onValueChange = { operator.value = it },
            label = { Text(text = "Operator") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            )
        )
        val result = when (operator.value) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> 0.0
        }
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = secondNumberInput.value,
            onValueChange = { secondNumberInput.value = it },
            label = { Text(text = "Second Number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus(true) }
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.number_result, result),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            color = textColor,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("back")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "BackGround",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("roll/${name.value}")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "DiceRoller",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.Blue
            )
        }
        Row(
            modifier = Modifier
                .padding(all = 8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_android_black_24dp),
                contentDescription = "Row Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Jetpack")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Compose")
            }
        }
    }
}
