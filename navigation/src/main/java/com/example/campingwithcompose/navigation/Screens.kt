package com.example.campingwithcompose.navigation

import androidx.navigation.NamedNavArgument

 sealed class Screens(val route: String) {
    object Splash : Screens("splashScreen")
    object OnBoarding : Screens("onBoarding")
    object Login : Screens("login")
    object Home : Screens("homeScreen")
    object Fitness : Screens("fitness")
    object BackPack : Screens("backPack")
    object TeamMates : Screens("teamMates")
    object Default : Screens("")
}
