package com.example.campingwithcompose.core.ui.navigation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Toolbar(
    modifier: Modifier,
    navigationAction: () -> Unit,
    title: String
) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = navigationAction,
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow left"
            )
        }

        Text(text = title, style = MaterialTheme.typography.titleLarge)
    }
}