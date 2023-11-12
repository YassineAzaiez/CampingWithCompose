package com.example.campingwithcompose.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class NavigationManager {

    private val _commands = Channel<Screen>()
    val commands get() = _commands.receiveAsFlow()

    suspend fun navigate(
        directions: Screen
    ) {
        _commands.send(directions)
    }

}