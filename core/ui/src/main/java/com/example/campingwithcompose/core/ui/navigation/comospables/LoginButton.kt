package com.example.campingwithcompose.core.ui.navigation.comospables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginButton(
    modifier: Modifier,
    action: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = action
    ) {
        Text("Log in")
    }
}
