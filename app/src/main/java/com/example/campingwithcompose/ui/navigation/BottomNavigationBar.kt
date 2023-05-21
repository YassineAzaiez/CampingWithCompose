package com.example.campingwithcompose.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(
    MenuItems: List<NavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onMenuItemClicked: (String) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar(modifier = modifier) {
        MenuItems.forEach { item ->
            val isItemSelected = item.itemRoute == backStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = isItemSelected,
                onClick = {
                    onMenuItemClicked(item.itemRoute)
                },
                icon = {
                    Column(
                        modifier = Modifier.background(Color.Transparent),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(25.dp),
                            painter = rememberVectorPainter(
                                item.itemIcon
                            ), contentDescription = item.itemName,
                        )

                        if (isItemSelected) Text(
                            text = item.itemName
                        )


                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(LocalAbsoluteTonalElevation.current)
                )
            )

        }


    }


}