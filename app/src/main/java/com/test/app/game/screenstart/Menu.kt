package com.test.app.game.screenstart

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.test.app.game.R


@Composable
fun MenuScreen(navController: NavController, key: String) {

    val context = LocalContext.current
    val interactionSource = remember {
        MutableInteractionSource()
    }

    fun exit() {
        (context as? Activity)?.finish()
    }
    BackHandler {
        exit()
    }
    LaunchedEffect(true) {
        if (key != "Nguyen") {
            exit()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("field")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Play Game",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("options")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Options",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("about")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "About",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    exit()
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Exit",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("first")
                }
                .padding(8.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(color = Color.Green, shape = RoundedCornerShape(100)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Test",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Blue
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