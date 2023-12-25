package com.example.campingwithcompose.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.campingwithcompose.core.ui.navigation.theme.Dimensions.BottomBar.BottomNavHeight
import com.example.campingwithcompose.core.ui.navigation.utils.noRippleClickable


@Composable
fun BottomNavigationBar(
    menuItems: List<NavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onMenuItemClicked: (String) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    Row(
        modifier = modifier
            .height(BottomNavHeight)
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        menuItems.forEach { item ->
            AddItem(
                item, backStackEntry.value?.destination,
                onMenuItemClicked = onMenuItemClicked
            )

        }
    }

}


@Composable
fun AddItem(
    item: NavigationItem,
    currentDestination: NavDestination?,
    onMenuItemClicked: (String) -> Unit
) {
    val selected = item.itemRoute == currentDestination?.route

    val color = if (selected) MaterialTheme.colorScheme.background else Color.Transparent



    Box(
        modifier = Modifier
            .height(40.dp)
            .background(color, shape = CircleShape)
            .noRippleClickable{
                onMenuItemClicked(item.itemRoute)
            }

    ) {
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {


            Icon(
                painter = rememberVectorPainter(
                    item.itemIcon

                ), contentDescription = item.itemName,
                tint = MaterialTheme.colorScheme.onPrimary
            )





            AnimatedVisibility(visible = selected) {
                Text(
                    text = item.itemName,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}
