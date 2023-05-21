package com.example.campingwithcompose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.campingwithcompose.R
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen

data class NavigationItem(
    val itemName: String,
    val itemIcon: ImageVector,
    val itemRoute: String,
)


