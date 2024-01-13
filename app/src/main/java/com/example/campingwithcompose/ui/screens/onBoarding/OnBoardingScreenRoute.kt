package com.example.campingwithcompose.ui.screens.onBoarding

import Launch
import Screens
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.campingwithcompose.ui.screens.onBoarding.splashScreen.SplashScreen


fun NavGraphBuilder.onBoardingGraph() {
    navigation(
        route = Screens.Splash.route,
        startDestination = Launch.Splash.route
    ) {
        addSplash()
        addOnBoarding()
    }

}

fun NavGraphBuilder.addSplash() {
    composable(
        Launch.Splash.route,
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
    ) { SplashScreen(hiltViewModel()) }
}

fun NavGraphBuilder.addOnBoarding() {
    composable(
        Launch.OnBoarding.route,
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
    ) { OnBoardingScreen(hiltViewModel()) }
}