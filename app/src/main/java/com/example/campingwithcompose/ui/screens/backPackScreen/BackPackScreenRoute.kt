package com.example.campingwithcompose.ui.screens.backPackScreen

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.campingwithcompose.ui.screens.homeScreen.HomeScreen
import androidx.navigation.compose.composable
import com.example.campingwithcompose.core.ui.navigation.Screen


fun NavGraphBuilder.backPackScreenRoute(navController: NavController) {
    composable(
      Screen.BackPack.route,
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -300 },
                animationSpec = tween(
                    300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(200))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -300 },
                animationSpec = tween(
                    300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(200))
        }
    ) { HomeScreen(navController) }
}