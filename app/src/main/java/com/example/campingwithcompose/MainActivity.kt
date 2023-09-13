package com.example.campingwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.campingwithcompose.ui.CampingApp
import com.example.campingwithcompose.ui.navigation.CampingAppNavGraph
import com.example.campingwithcompose.ui.screens.homeScreen.Greeting
import com.example.campingwithcompose.ui.theme.CampingWithComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CampingWithComposeTheme {
                CampingApp()
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CampingWithComposeTheme(dynamicColor = false) {
        Greeting()
    }
}