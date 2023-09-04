package com.example.campingwithcompose.ui

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.campingwithcompose.R
import com.example.campingwithcompose.ui.navigation.BottomNavigationBar
import com.example.campingwithcompose.ui.navigation.CampingAppNavGraph
import com.example.campingwithcompose.ui.navigation.NavigationItem
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen
import com.example.campingwithcompose.ui.theme.Dimensions
import com.example.campingwithcompose.utils.showBars
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CampingApp() {
    //        AnimatedVisibility(
//            visible = backStackEntry.value?.destination?.route != Screen.ItemDetailsScreen.route,
//            enter = slideInVertically(animationSpec = tween(1000)) { it },
//            exit = slideOutVertically(animationSpec = tween(400)) { it }
//        ) {
//
//        }
    val menuItems = listOf(
        NavigationItem(
            itemName = "Activities",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_actitivites),
            itemRoute = Screen.Home.route
        ),
        NavigationItem(
            itemName = "Fitness",
            itemIcon = Icons.Default.ArrowBack,
            itemRoute = Screen.Fitness.route
        ),
        NavigationItem(
            itemName = "BackPack",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_backpack),
            itemRoute = Screen.BackPack.route
        ),
        NavigationItem(
            itemName = "TeamMates",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_teamates),
            itemRoute = Screen.TeamMates.route
        )
    )

    val navController = rememberAnimatedNavController()
//    val backStackEntry = navController.currentBackStackEntryAsState()
    Scaffold(bottomBar = {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val hideBottomNavigation =
            (backStackEntry.value?.destination?.route in menuItems.map { it.itemRoute })
        showBars(flag = true)
        if (hideBottomNavigation)
            BottomNavigationBar(
                MenuItems = menuItems, navController = navController,
                modifier = Modifier.height(Dimensions.BottomBar.BottomNavHeight)
            ) { route ->
                navController.navigate(route)
            }

    }) {
        CampingAppNavGraph(navController = navController)
    }

}
