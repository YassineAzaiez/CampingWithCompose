package com.example.campingwithcompose.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String, val arguments: List<NamedNavArgument> = emptyList()) {
    object Splash : Screen("splashScreen")
    object OnBoarding : Screen("onBoarding")
    object Login : Screen("login")
    object Home : Screen("homeScreen")
    object Fitness : Screen("fitness")
    object BackPack : Screen("backPack")
    object TeamMates : Screen("teamMates")
    object Default : Screen("")
}
