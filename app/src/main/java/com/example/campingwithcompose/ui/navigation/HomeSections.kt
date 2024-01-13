package com.example.campingwithcompose.ui.navigation

import Screens
import androidx.annotation.StringRes
import com.example.campingwithcompose.R

enum class HomeSections(
    @StringRes val title: Int,
    val icon: Int,
    val route: String
) {
    ACTIVITIES(
        title = R.string.activities,
        icon = R.drawable.ic_actitivites,
        route = Screens.Home.route
    ),
    FITNESS(
        title = R.string.fitness,
        icon = R.drawable.ic_fill_heart,
        route = Screens.Fitness.route
    ),
    BACKPACK(
        title = R.string.backPack,
        icon = R.drawable.ic_backpack,
        route = Screens.BackPack.route
    ),
    TEAMMATES(
        title = R.string.teamMates,
        icon = R.drawable.ic_teamates,
        route = Screens.TeamMates.route
    )
}