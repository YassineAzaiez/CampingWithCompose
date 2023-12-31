package com.example.campingwithcompose.navigation

import Screens
import android.util.Log
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

class NavigationManager {

    private val _commands = MutableSharedFlow<Screens>()
    val commands get() = _commands.asSharedFlow()
    suspend fun navigate(
        directions: Screens,
    ) {
        _commands.emit(directions)
    }

}