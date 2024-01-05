package com.example.campingwithcompose.ui

import Authentication
import Launch
import Screens
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.campingwithcompose.R
import com.example.campingwithcompose.core.ui.navigation.theme.Dimensions
import com.example.campingwithcompose.navigation.NavigationManager
import com.example.campingwithcompose.ui.navigation.BottomNavigationBar
import com.example.campingwithcompose.ui.navigation.CampingAppNavGraph
import com.example.campingwithcompose.ui.navigation.NavigationItem
import com.example.campingwithcompose.ui.screens.homeScreen.Greeting
import com.example.compose.CampingWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
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
                LaunchedEffect(Unit) {
                    lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            navigationManager.commands.collect { command ->
                                if (command.route.isNotEmpty()) {
                                    navController.navigate(command.route) {

                                        if (command == Launch.OnBoarding) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                inclusive = true
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
                Surface (
                    tonalElevation = 5.dp
                ){
                    CampingApp(navController)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CampingApp(navController: NavHostController) {


    val menuItems = listOf(
        NavigationItem(
            itemName = "Activities",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_actitivites),
            itemRoute = Screens.Home.route
        ), NavigationItem(
            itemName = "Fitness",
            itemIcon = Icons.Default.ArrowBack,
            itemRoute = Screens.Fitness.route
        ), NavigationItem(
            itemName = "BackPack",
            itemIcon = ImageVector.vectorResource(id = R.drawable.ic_backpack),
            itemRoute = Screens.BackPack.route
        ), NavigationItem(
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
            menuItems = menuItems,
            navController = navController,
            modifier = Modifier.height(Dimensions.BottomBar.BottomNavHeight)
        ) { route ->
            navController.navigate(route) {
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

    }) {
        CampingAppNavGraph(navController = navController)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CampingWithComposeTheme(dynamicColor = false) {
        Greeting()
    }
}