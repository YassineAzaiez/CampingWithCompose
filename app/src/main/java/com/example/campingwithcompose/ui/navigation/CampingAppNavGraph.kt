package com.example.campingwithcompose.ui.navigation

import Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.campingwithcompose.ui.screens.backPackScreen.backPackScreenRoute
import com.example.campingwithcompose.ui.screens.favoritScreen.fitnessScreenRoute
import com.example.campingwithcompose.ui.screens.homeScreen.homeScreenRoute
import com.example.campingwithcompose.ui.screens.onBoarding.onBoardingGraph
import com.example.campingwithcompose.ui.screens.teamMatesScreen.teamMatesScreenRoute
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
        homeScreenRoute()
        teamMatesScreenRoute()
        fitnessScreenRoute()
        backPackScreenRoute()
    }
}

private val NavGraph.startDestination: NavDestination?
    get() =
        findNode(startDestinationId)

tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}