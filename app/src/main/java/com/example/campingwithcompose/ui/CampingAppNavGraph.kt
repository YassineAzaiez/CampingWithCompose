package com.example.campingwithcompose.ui


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.campingwithcompose.ui.screens.backPackScreen.backPackScreenRoute
import com.example.campingwithcompose.ui.screens.favoritScreen.fitnessScreenRoute
import com.example.campingwithcompose.ui.screens.homeScreen.homeScreenRoute
import com.example.campingwithcompose.ui.screens.onBoarding.onBoardingScreenRoute
import com.example.campingwithcompose.ui.screens.splashScreen.splashScreenRoute
import com.example.campingwithcompose.ui.screens.teamMatesScreen.teamMatesScreenRoute
import com.example.ui.authentication.loginScreen.loginScreenRoute


@Composable
fun CampingAppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = com.example.campingwithcompose.navigation.Screens.Splash.route
    ) {

        splashScreenRoute()
        onBoardingScreenRoute()
        loginScreenRoute(onUserLogin = {}, onRegisterBtnClick = {}) {}
        homeScreenRoute()
        teamMatesScreenRoute()
        fitnessScreenRoute()
        backPackScreenRoute()
    }
}