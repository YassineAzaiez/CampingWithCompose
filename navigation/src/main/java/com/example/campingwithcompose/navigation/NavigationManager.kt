package com.example.campingwithcompose.navigation

import Screens
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManager {

    private val _commands = MutableSharedFlow<Screens>()
    val commands get() = _commands.asSharedFlow()
    suspend fun navigate(
        directions: Screens,
    ) {
        _commands.emit(directions)
    }

}