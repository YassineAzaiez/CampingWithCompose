package com.example.ui.authentication.loginScreen

import Authentication
import Screens
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.loginGraph(
    onUserLogin: () -> Unit,
    onRegisterBtnClick : ( ) -> Unit,
    onForgetPassword: () -> Unit
) {
    navigation(
        route = Screens.Auth.route,
        startDestination = Authentication.Login.route
    ) {
        addLogin(onUserLogin, onRegisterBtnClick, onForgetPassword)
    }

}


fun NavGraphBuilder.addLogin(
    onUserLogin: () -> Unit,
    onRegisterBtnClick: () -> Unit,
    onForgetPassword: () -> Unit
) {
    composable(
        Authentication.Login.route,
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
    ) {
        LoginScreen(
            onUserLogin,
            onRegisterBtnClick,
            onForgetPassword

        )
    }

}