package com.example.campingwithcompose.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class NavigationManager {

    private val _commands = Channel<Screens>()
    val commands get() = _commands.receiveAsFlow()
    suspend fun navigate(
        directions: Screens,
    ) {
        _commands.send(directions)
    }

}