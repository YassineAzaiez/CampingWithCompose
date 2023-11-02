package com.example.campingwithcompose.core.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val itemName: String,
    val itemIcon: ImageVector,
    val itemRoute: String,
)

