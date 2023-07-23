package com.test.app.game

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.test.app.game.datalist.*
import com.test.app.game.screenfinish.*
import com.test.app.game.screengame.*
import com.test.app.game.screenstart.*

@Composable
fun AppNavigationComponent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("key") {
            KeywordScreen(navController)
        }
        composable("menu/{$KEY}") {
            val key: String = it.arguments?.getString(KEY) ?: ""
            MenuScreen(navController, key)
        }
        composable("options") {
            OptionsScreen(navController)
        }
        composable("about") {
            AboutScreen(navController)
        }
        composable("back") {
            BackGround(navController)
        }
        composable("roll/{$NAME}") {
            val name: String = it.arguments?.getString(NAME) ?: ""
            DiceRoller(navController, name)
        }
        composable("time/{$NAME}") {
            val name: String = it.arguments?.getString(NAME) ?: ""
            CountingTime(navController, name)
        }
        composable("game/{$CATEGORY}") {
            val category: String = it.arguments?.getString(CATEGORY) ?: Category.MATH
            GameScreen(navController, category)
        }
        composable("field") {
            ChooseFieldScreen(navController)
        }
        composable("first") {
            FirstTestScreen(navController)
        }
        composable("second/{$NAME}") {
            val name: String = it.arguments?.getString(NAME) ?: ""
            SecondTestScreen(navController, name)
        }
        composable("tip") {
            TipTimeScreen(navController)
        }
        composable("image") {
            AffirmationScreen(navController)
        }
        composable("topic") {
            TopicScreen(navController)
        }
        composable(
            route = "showG/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersGScreen(navController, score)
        }

        composable(
            route = "showH/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersHScreen(navController, score)
        }

        composable(
            route = "showM/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersMScreen(navController, score)
        }

        composable(
            route = "showC/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersCScreen(navController, score)
        }

        composable(
            route = "showP/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersPScreen(navController, score)
        }

        composable(
            route = "showL/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersLScreen(navController, score)
        }

        composable(
            route = "showA/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersAScreen(navController, score)
        }

        composable(
            route = "showW/{$SCORE}",
            arguments = listOf(
                navArgument(SCORE) { type = NavType.IntType }
            )
        ) {
            val score: Int = it.arguments?.getInt(SCORE) ?: 0
            ShowAnswersWScreen(navController, score)
        }
    }
}
