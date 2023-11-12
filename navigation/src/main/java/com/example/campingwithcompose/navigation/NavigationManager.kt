package com.example.campingwithcompose.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationManager {

    private val _commands = MutableStateFlow<Screens>(Screens.Default)
    val commands get() = _commands.asStateFlow()

    suspend fun navigate(
        directions: Screens
    ) {
        _commands.emit(directions)
    }

}