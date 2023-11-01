package com.example.ui.authentication.loginScreen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.campingwithcompose.core.ui.navigation.Screen


fun NavGraphBuilder.loginScreenRoute(
    onUserLogin: () -> Unit,
    onRegisterBtnClick : ( ) -> Unit,
    onForgetPassword : ()->Unit
) {
    composable(
        Screen.Login.route,
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
    ) { LoginScreen(
        onUserLogin,
        onRegisterBtnClick,
        onForgetPassword

    ) }
}