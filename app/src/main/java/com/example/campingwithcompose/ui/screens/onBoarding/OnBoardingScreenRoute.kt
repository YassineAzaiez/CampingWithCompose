package com.example.campingwithcompose.ui.screens.onBoarding

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.campingwithcompose.core.ui.navigation.Screen


fun NavGraphBuilder.onBoardingScreenRoute(onLoginClick : ()->Unit , onRegisterClick : ()->Unit) {
    composable(
       Screen.OnBoarding.route,
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
    ) { OnBoardingScreen(onLoginClick,onRegisterClick) }
}