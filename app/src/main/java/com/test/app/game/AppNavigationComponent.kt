package com.test.app.game

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.test.app.game.datalist.CATEGORY
import com.test.app.game.datalist.Category
import com.test.app.game.datalist.SCORE
import com.test.app.game.datalist.NAME
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
        composable("menu") {
            MenuScreen(navController)
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
        composable("roll") {
            DiceRoller(navController)
        }
        composable("delay") {
            DelayScreen(navController)
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
    }
}
