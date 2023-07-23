package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
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
        navController.popBackStack()
    }
    Column(
        modifier = Modifier
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

@Composable
fun DisplayIcon() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorite Icon",
        tint = Color.Red
    )
}
