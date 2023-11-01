package com.example.campingwithcompose.ui.screens.teamMatesScreen

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.campingwithcompose.core.ui.navigation.Screen
import com.example.campingwithcompose.ui.screens.homeScreen.HomeScreen


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.teamMatesScreenRoute(navController: NavController) {
    composable(
        Screen.TeamMates.route,
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