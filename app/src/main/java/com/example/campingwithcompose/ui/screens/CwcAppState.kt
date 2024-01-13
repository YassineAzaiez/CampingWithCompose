package com.example.campingwithcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.campingwithcompose.ui.navigation.HomeSections

@Composable
fun rememberNiaAppState(
    navController: NavHostController = rememberNavController(),
): CwcAppState {

    return remember(
        navController,

        ) {
        CwcAppState(
            navController,
        )
    }
}

@Stable
class CwcAppState(
    val navController: NavHostController,
) {
    val bottomBarTabs = HomeSections.values()
    private val bottomBarRoutes = bottomBarTabs.map { it.route }
    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes


    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun navigateToTopLevelDestination(topLevelDestination: String) {
        navController.navigate(topLevelDestination) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }


}