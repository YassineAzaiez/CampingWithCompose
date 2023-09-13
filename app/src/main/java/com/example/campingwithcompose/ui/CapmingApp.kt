package com.example.campingwithcompose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.campingwithcompose.R
import com.example.campingwithcompose.ui.navigation.BottomNavigationBar
import com.example.campingwithcompose.ui.navigation.CampingAppNavGraph
import com.example.campingwithcompose.ui.navigation.NavigationItem
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen
import com.example.campingwithcompose.ui.theme.Dimensions


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CampingApp() {


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

    val navController = rememberNavController()
//    val backStackEntry = navController.currentBackStackEntryAsState()
    Scaffold(bottomBar = {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val hideBottomNavigation =
            (backStackEntry.value?.destination?.route in menuItems.map { it.itemRoute })
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
