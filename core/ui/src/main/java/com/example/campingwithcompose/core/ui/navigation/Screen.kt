package com.example.campingwithcompose.core.ui.navigation

sealed class Screen (val route : String){
    object Splash : Screen("splashScreen")
    object OnBoarding : Screen("onBoarding")
    object Login : Screen("login")
    object Home : Screen("homeScreen")
    object Fitness : Screen("fitness")
    object BackPack : Screen("backPack")
    object TeamMates : Screen("teamMates")
}
