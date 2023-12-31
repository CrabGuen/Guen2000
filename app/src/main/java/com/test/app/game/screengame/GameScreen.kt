package com.test.app.game.screengame

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.navigation.NavHostController
import com.test.app.game.datalist.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.app.game.R
import kotlinx.coroutines.delay

@Composable
fun GameScreen(navController: NavHostController, category: String) {

    BackHandler {
        navController.navigate("field")
    }

    val randomQuestions = remember { mutableStateOf(getRandomUniqueQuestions(category)) }

    val index = remember { mutableStateOf(1) }

    val ansIndex = remember { mutableStateOf(0) }

    val currentQuestion = remember { mutableStateOf(randomQuestions.value?.get(index.value - 1)) }

    val score = remember { mutableStateOf(0) }

    val interactionSource = remember { MutableInteractionSource() }

    val isAnswered = remember { mutableStateOf(false) }

    var boxColor by remember { mutableStateOf(Color.Blue) }

    val isChange = remember { mutableStateOf(false) }

    val isTime = remember { mutableStateOf(1300) }

    fun checkAnswer(answerIndex: Int) {
        if (answerIndex == currentQuestion.value?.answer) {
            // Update the score
            boxColor = Color.Green
            score.value++
        } else {
            boxColor = Color.Red
        }
        isTime.value = 0
        isChange.value = true
    }

    LaunchedEffect(isAnswered.value) {
        if (isAnswered.value) {
            checkAnswer(ansIndex.value)
        }
    }
    LaunchedEffect(isChange.value) {
        if (isChange.value) {
            delay(1600)
            isAnswered.value = false
            boxColor = Color.Blue
            index.value++
            currentQuestion.value = randomQuestions.value?.get(index.value - 1)
            isTime.value = 1300
            isChange.value = false
        }
    }
    if (index.value == 11) {
        boxColor = Color.White
    }
    if (isTime.value > 0) {
        isTime.value -= 1
    }
    if (isTime.value == 0) {
        isChange.value = true
    }
    // Main layout
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Quiz Game",
            fontSize = 33.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "<${isTime.value}>",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Cyan
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Question
        val question = "Question ${index.value}: ${currentQuestion.value?.question}"
        Text(
            text = question,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = if (index.value == 11) Color.White else Color.Gray
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        // Options
        currentQuestion.value?.options?.forEachIndexed { i, option ->
            Box(
                modifier = Modifier
                    .clickable(interactionSource = interactionSource, indication = null) {
                        ansIndex.value = i
                        isAnswered.value = true
                    }
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(color = boxColor, shape = RoundedCornerShape(100)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = option,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(
            modifier = Modifier.height(22.dp)
        )
        // Score
        Text(
            text = "Your score is ${score.value}/10",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(
            modifier = Modifier.height(2.dp)
        )
        if (score.value == 10 && index.value == 11) {
            Text(
                text = "Congratulation",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.Green
            )
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .clickable(interactionSource = interactionSource, indication = null) {
                        navController.navigate("field")
                    }
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(color = Color.Green, shape = RoundedCornerShape(100)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Next Field",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.White
                )
            }
        } else if (index.value == 11 && score.value <= 9) {
            Text(
                text = "Mission Fail",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.Red
            )
            Box(
                modifier = Modifier
                    .clickable(interactionSource = interactionSource, indication = null) {
                        navController.navigate("game/$category")
                    }
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(color = Color.Red, shape = RoundedCornerShape(100)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Play Again",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.White
                )
            }
        } else {
            Text(
                text = "",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White
            )
        }
        Spacer(
            modifier = Modifier.height(2.dp)
        )
        if (index.value == 11 && score.value >= 8) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Color.Yellow, shape = RoundedCornerShape(100))
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable(interactionSource = interactionSource, indication = null) {
                        when (category) {
                            Category.MATH -> navController.navigate("showM/${score.value}")
                            Category.PHYSICS -> navController.navigate("showP/${score.value}")
                            Category.HISTORY -> navController.navigate("showH/${score.value}")
                            Category.GEOGRAPHY -> navController.navigate("showG/${score.value}")
                            Category.CHEMISTRY -> navController.navigate("showC/${score.value}")
                            Category.LITERATURE -> navController.navigate("showL/${score.value}")
                            Category.AMERICAN -> navController.navigate("showA/${score.value}")
                            Category.WORLD -> navController.navigate("showW/${score.value}")
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Show Answers",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.White
                )
            }
        } else {
            Text(
                text = "",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White
            )
        }
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
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


