package com.example.campingwithcompose.ui

import Launch
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.campingwithcompose.core.ui.navigation.theme.Dimensions
import com.example.campingwithcompose.navigation.NavigationManager
import com.example.campingwithcompose.ui.navigation.BottomNavigationBar
import com.example.campingwithcompose.ui.navigation.CampingAppNavGraph
import com.example.campingwithcompose.ui.navigation.findStartDestination
import com.example.campingwithcompose.ui.screens.CwcAppState
import com.example.campingwithcompose.ui.screens.homeScreen.Greeting
import com.example.campingwithcompose.ui.screens.rememberNiaAppState
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
        enableEdgeToEdge()

        setContent {
            val appState = rememberNiaAppState()

            CampingWithComposeTheme {
                LaunchedEffect(Unit) {
                    lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            navigationManager.commands.collect { command ->
                                if (command.route.isNotEmpty()) {
                                    appState.navController.navigate(command.route,) {
                                        if (command == Authentication.Login) {
                                            popUpTo(
                                                appState.navController.graph.startDestinationRoute ?: ""
                                            ) {
                                                inclusive = true
                                            }
                                        }
                                        if (command == Launch.OnBoarding) {
                                            popUpTo(findStartDestination(appState.navController.graph).id) {
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
                    CampingApp(modifier = Modifier,appState)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CampingApp(modifier: Modifier , appState: CwcAppState) {

    Scaffold(
        modifier = modifier,
        bottomBar = {
        if (appState.shouldShowBottomBar) BottomNavigationBar(
            menuItems = appState.bottomBarTabs,
            modifier = Modifier.height(Dimensions.BottomBar.BottomNavHeight),
            currentRoute = appState.currentRoute!!,
        ) { route ->
            appState.navigateToTopLevelDestination(route)
        }

    }) {
        CampingAppNavGraph(navController = appState.navController)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CampingWithComposeTheme(dynamicColor = false) {
        Greeting()
    }
}