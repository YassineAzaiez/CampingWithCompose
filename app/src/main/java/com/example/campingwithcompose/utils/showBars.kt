package com.example.campingwithcompose.utils

import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun showBars(flag : Boolean) {

    rememberSystemUiController().apply {
        isSystemBarsVisible = flag


    }
}