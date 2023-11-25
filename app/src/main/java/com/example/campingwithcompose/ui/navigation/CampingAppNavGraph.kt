package com.example.campingwithcompose.ui.navigation


import Screens
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.campingwithcompose.ui.screens.backPackScreen.backPackScreenRoute
import com.example.campingwithcompose.ui.screens.favoritScreen.fitnessScreenRoute
import com.example.campingwithcompose.ui.screens.homeScreen.homeScreenRoute
import com.example.campingwithcompose.ui.screens.onBoarding.onBoardingGraph
import com.example.campingwithcompose.ui.screens.teamMatesScreen.teamMatesScreenRoute
import com.example.ui.authentication.loginScreen.loginGraph


@Composable
fun CampingAppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {

        onBoardingGraph()
        loginGraph(onUserLogin = {}, onRegisterBtnClick = {}) {}
        homeScreenRoute()
        teamMatesScreenRoute()
        fitnessScreenRoute()
        backPackScreenRoute()
    }
}