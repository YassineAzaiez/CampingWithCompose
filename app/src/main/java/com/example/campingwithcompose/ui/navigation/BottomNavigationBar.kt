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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.campingwithcompose.R
import com.example.campingwithcompose.core.ui.navigation.theme.Dimensions.BottomBar.BottomNavHeight
import com.example.campingwithcompose.core.ui.navigation.utils.noRippleClickable


@Composable
fun BottomNavigationBar(
    menuItems: Array<HomeSections>,
    currentRoute: String,
    modifier: Modifier = Modifier,
    navigateToRoute: (String) -> Unit,
) {

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
                item, currentRoute, onMenuItemClicked = navigateToRoute
            )

        }
    }

}


@Composable
fun AddItem(
    item: HomeSections, currentDestination: String, onMenuItemClicked: (String) -> Unit
) {
    val selected = item.route == currentDestination

    val color = if (selected) MaterialTheme.colorScheme.background else Color.Transparent



    Box(
        modifier = Modifier
            .height(40.dp)
            .background(color, shape = CircleShape)
            .noRippleClickable {
                onMenuItemClicked(item.route)
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
                    ImageVector.vectorResource(id = R.drawable.ic_actitivites)

                ),
                contentDescription = stringResource(id = item.title),
                tint = MaterialTheme.colorScheme.onPrimary
            )





            AnimatedVisibility(visible = selected) {
                Text(
                    text = stringResource(id = item.title),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}
