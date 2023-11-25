package com.example.campingwithcompose.ui.screens.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Greeting()
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier.fillMaxSize(),

        ) {
        Text(
            text = "Hello Camper",

            )
    }

}