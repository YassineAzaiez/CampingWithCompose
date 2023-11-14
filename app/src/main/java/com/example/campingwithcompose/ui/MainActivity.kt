package com.example.campingwithcompose.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.campingwithcompose.R
import com.example.campingwithcompose.core.ui.navigation.theme.CampingWithComposeTheme
import com.example.campingwithcompose.core.ui.navigation.theme.Dimensions
import com.example.campingwithcompose.navigation.NavigationManager
import com.example.campingwithcompose.navigation.Screens
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
                navigationManager.commands.collectAsStateWithLifecycle(Screens.Default).value.also { command ->
                    if (command.route.isNotEmpty()) {
                        navController.navigate(command.route) {
                            if (command == Screens.Login ) {
                                popUpTo(Screens.OnBoarding.route) {
                                    inclusive = true
                                }
                                launchSingleTop = (command as Screens.Login ).launchInclusive
                            }
                            if(command == Screens.OnBoarding) {
                                popUpTo(Screens.Splash.route) {
                                    inclusive = true
                                }
                            }
                        }
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
            itemRoute = Screens.Home.route
        ), com.example.campingwithcompose.core.ui.navigation.NavigationItem(
            itemName = "Fitness",
            itemIcon = Icons.Default.ArrowBack,
            itemRoute = Screens.Fitness.route
        ), com.example.campingwithcompose.core.ui.navigation.NavigationItem(
            itemName = "BackPack",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_backpack),
            itemRoute = Screens.BackPack.route
        ), com.example.campingwithcompose.core.ui.navigation.NavigationItem(
            itemName = "TeamMates",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_teamates),
            itemRoute = Screens.TeamMates.route
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