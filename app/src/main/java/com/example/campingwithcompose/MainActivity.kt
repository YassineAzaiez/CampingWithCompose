package com.example.campingwithcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.campingwithcompose.core.ui.navigation.theme.CampingWithComposeTheme
import com.example.campingwithcompose.core.ui.navigation.theme.Dimensions
import com.example.campingwithcompose.navigation.NavigationManager
import com.example.campingwithcompose.navigation.Screen
import com.example.campingwithcompose.ui.BottomNavigationBar
import com.example.campingwithcompose.ui.CampingAppNavGraph
import com.example.campingwithcompose.ui.screens.homeScreen.Greeting
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CampingWithComposeTheme {
                val navController = rememberNavController()
                navigationManager.commands.collectAsState(Screen.Default).value.also { command ->
                    if (command.route.isNotEmpty()) {
                        navController.navigate(command.route)
                    }
                }


                CampingApp(navController)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CampingApp(navController: NavHostController) {


    val menuItems = listOf(
        com.example.campingwithcompose.core.ui.navigation.NavigationItem(
            itemName = "Activities",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_actitivites),
            itemRoute = com.example.campingwithcompose.navigation.Screen.Home.route
        ), com.example.campingwithcompose.core.ui.navigation.NavigationItem(
            itemName = "Fitness",
            itemIcon = Icons.Default.ArrowBack,
            itemRoute = com.example.campingwithcompose.navigation.Screen.Fitness.route
        ), com.example.campingwithcompose.core.ui.navigation.NavigationItem(
            itemName = "BackPack",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_backpack),
            itemRoute = com.example.campingwithcompose.navigation.Screen.BackPack.route
        ), com.example.campingwithcompose.core.ui.navigation.NavigationItem(
            itemName = "TeamMates",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_teamates),
            itemRoute = com.example.campingwithcompose.navigation.Screen.TeamMates.route
        )
    )


//    val backStackEntry = navController.currentBackStackEntryAsState()
    Scaffold(bottomBar = {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val hideBottomNavigation =
            (backStackEntry.value?.destination?.route in menuItems.map { it.itemRoute })
        if (hideBottomNavigation) BottomNavigationBar(
            MenuItems = menuItems,
            navController = navController,
            modifier = Modifier.height(Dimensions.BottomBar.BottomNavHeight)
        ) { route ->
            navController.navigate(route)
        }

    }) {
        CampingAppNavGraph(navController = navController)
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CampingWithComposeTheme(dynamicColor = false) {
        Greeting()
    }
}