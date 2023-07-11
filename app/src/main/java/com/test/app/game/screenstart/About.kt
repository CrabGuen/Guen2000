package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.test.app.game.R

@Composable
fun AboutScreen(navController: NavHostController) {
    BackHandler {
        navController.navigate("menu")
    }
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Quiz Game",
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Dang The Nguyen",
            fontSize = 24.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Mobile App Developer",
            fontSize = 22.sp,
            color = Color.Blue
        )
        // Icon
        Spacer(modifier = Modifier.height(12.dp))
        repeat(3) {
            DisplayIcon()
        }
        Spacer(modifier = Modifier.height(6.dp))
        // test background
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
        repeat(1) {
            MyIcon()
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("roll")
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
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("delay")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Delay Screen",
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
@Composable
fun DisplayIcon() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorite Icon"
    )
}
@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Default.Email,
        contentDescription = "Email Icon"
    )
}