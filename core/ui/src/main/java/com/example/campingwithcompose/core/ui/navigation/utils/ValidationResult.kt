package com.example.campingwithcompose.core.ui.navigation.utils

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)