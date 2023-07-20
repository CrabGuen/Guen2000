package com.test.app.game.screengame

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.test.app.game.R
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.test.app.game.datalist.DataTopic
import com.test.app.game.datalist.Topic

@Composable
fun TopicScreen(navController: NavController, modifier: Modifier = Modifier) {

    BackHandler {
        navController.popBackStack()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(DataTopic.topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(topic.imageRes),
                    contentDescription = null,
                    modifier = modifier
                        .size(68.dp, 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    text = stringResource(topic.stringRes),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    ),
                    color = colorResource(R.color.purple_200)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_android_black_24dp),
                        contentDescription = null,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium)
                        )
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_small)
                        ),
                        color = colorResource(R.color.pink)
                    )
                }
            }
        }
    }
}