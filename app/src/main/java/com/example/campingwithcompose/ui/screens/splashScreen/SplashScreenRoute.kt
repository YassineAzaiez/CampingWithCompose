package com.example.campingwithcompose.ui.screens.splashScreen

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen
import com.google.accompanist.navigation.animation.composable



@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashScreenRoute(navController: NavController) {
    composable(
        Screen.Splash.route,
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
    ) { SplashScreen(navController) }
}