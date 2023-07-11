package com.test.app.game.screenstart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.test.app.game.R

@Composable
fun FirstTestScreen(navController: NavController) {

    BackHandler {
        navController.navigate("menu")
    }

    val name = remember { mutableStateOf("") }

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            modifier = Modifier
                .requiredHeight(180.dp)
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
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(23.dp))
        Button(
            onClick = {
                navController.navigate("second/${name.value}")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(color = Color.Blue)
        ) {
            Text("Go to Second Screen")
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