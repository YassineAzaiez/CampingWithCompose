package com.example.campingwithcompose.ui.navigation

import Screens
import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.campingwithcompose.core.ui.navigation.common.OtpScreen
import com.example.campingwithcompose.ui.screens.backPackScreen.backPackScreenRoute
import com.example.campingwithcompose.ui.screens.favoritScreen.fitnessScreenRoute
import com.example.campingwithcompose.ui.screens.homeScreen.homeScreenRoute
import com.example.campingwithcompose.ui.screens.onBoarding.onBoardingGraph
import com.example.campingwithcompose.ui.screens.teamMatesScreen.teamMatesScreenRoute
import com.example.campingwithcompsoe.common.OTP_SOURCE
import com.example.campingwithcompsoe.common.utils.OtpSource
import com.example.ui.authentication.loginGraph


@Composable
fun CampingAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        modifier = modifier
    ) {

        onBoardingGraph()
        loginGraph()
        addOtpScreen(navController)
        homeScreenRoute()
        teamMatesScreenRoute()
        fitnessScreenRoute()
        backPackScreenRoute()
    }
}

fun NavGraphBuilder.addOtpScreen(navController: NavHostController) {
    composable(
        Screens.OtpScreen.route,
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
        },
        arguments = listOf(navArgument(OTP_SOURCE) {
            type = NavType.StringType
        })
    ) {

        it.arguments?.getString(OTP_SOURCE)?.let { source ->


            OtpScreen(source) {
                when (source) {
                    OtpSource.FORGET_PASSWORD.source -> {
                       navController.navigate(Screens.Home.route)
                    }
                    OtpSource.REGISTRATION.source -> {}
                }
            }

        }
    }
}

private val NavGraph.startDestination: NavDestination?
    get() =
        findNode(startDestinationId)

tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}