package com.test.app.game.screengame

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.app.game.R
import com.test.app.game.datalist.Category
import com.test.app.game.screenstart.DisplayIcon

@Composable
fun ChooseFieldScreen(navController: NavController) {

    val interactionSource = remember { MutableInteractionSource() }

    BackHandler {
        navController.navigate("menu")
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("game/${Category.MATH}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row {
                DisplayIcon()
                Text(
                    text = "MathIQ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("game/${Category.HISTORY}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row {
                DisplayIcon()
                Text(
                    text = "History",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("game/${Category.GEOGRAPHY}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row {
                DisplayIcon()
                Text(
                    text = "Geography",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("game/${Category.LITERATURE}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row {
                DisplayIcon()
                Text(
                    text = "Literature",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("game/${Category.PHYSICS}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row {
                DisplayIcon()
                Text(
                    text = "Physics",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("game/${Category.CHEMISTRY}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row {
                DisplayIcon()
                Text(
                    text = "Chemistry",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("game/${Category.AMERICAN}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row {
                DisplayIcon()
                Text(
                    text = "American",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Blue
                )
            }
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