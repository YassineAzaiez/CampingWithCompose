package com.example.campingwithcompose.ui.navigation.screenDestination

sealed class Screen (val route : String){
    object Splash : Screen("/splashScreen")
    object OnBoarding : Screen("/onBoarding")
    object Home : Screen("/homeScreen")
    object Fitness : Screen("/fitness")
    object BackPack : Screen("/backPack")
    object TeamMates : Screen("/teamMates")
}
