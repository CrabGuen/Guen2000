package com.test.app.game.screenstart

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.test.app.game.R

@Composable
fun OptionsScreen(navController: NavController) {

    BackHandler {
        navController.popBackStack()
    }
    var isChecked by remember { mutableStateOf(false) }

    var backgroundColor by remember { mutableStateOf(Color.White)}

    var checkColor by remember { mutableStateOf(false)}

    var textColor by remember { mutableStateOf(Color.Blue)}

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column {
            Text(
                text = "Options",
                color = textColor,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                fontWeight = FontWeight.Bold,
            )
            CheckboxSetting(
                label = "Text Mode",
                isChecked = checkColor,
                onCheckedChange = { checkColor = it },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            // Điều kiện cho Text Mode
            textColor = if (checkColor) {
                Color.Red
            } else {
                Color.Blue
            }
            CheckboxSetting(
                label = "Dark Mode",
                isChecked = isChecked,
                onCheckedChange = { isChecked = it },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            // Điều kiện cho Dark Mode
            backgroundColor = if (isChecked) {
                Color.LightGray
            } else {
                Color.White
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
    }
}

@Composable
fun CheckboxSetting(
    label: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
        )
        Text(
            text = label,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}