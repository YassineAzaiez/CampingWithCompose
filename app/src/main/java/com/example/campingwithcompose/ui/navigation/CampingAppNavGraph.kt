package com.example.campingwithcompose.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen
import com.example.campingwithcompose.ui.screens.BackPackScreen.backPackScreenRoute
import com.example.campingwithcompose.ui.screens.favoritScreen.fitnessScreenRoute
import com.example.campingwithcompose.ui.screens.homeScreen.homeScreenRoute
import com.example.campingwithcompose.ui.screens.loginScreen.loginScreenRoute
import com.example.campingwithcompose.ui.screens.onBoarding.onBoardingScreenRoute
import com.example.campingwithcompose.ui.screens.splashScreen.splashScreenRoute
import com.example.campingwithcompose.ui.screens.teamMatesScreen.teamMatesScreenRoute
import com.example.campingwithcompose.utils.showBars
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CampingAppNavGraph(navController: NavHostController) {
    AnimatedNavHost(navController = navController, startDestination = Screen.Splash.route) {
        splashScreenRoute(navController)
        onBoardingScreenRoute(navController)
        loginScreenRoute(navController)
        homeScreenRoute(navController)
        teamMatesScreenRoute(navController)
        fitnessScreenRoute(navController)
        backPackScreenRoute(navController)
    }
}