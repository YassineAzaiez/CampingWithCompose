package com.example.campingwithcompose.core.ui.navigation.utils

data class ValidationResult(
    var successful: Boolean,
    var errorMessage: UiText? = null
)