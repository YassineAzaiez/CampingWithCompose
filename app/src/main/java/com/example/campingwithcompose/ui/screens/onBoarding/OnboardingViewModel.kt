package com.example.campingwithcompose.ui.screens.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campingwithcompose.navigation.NavigationManager
import com.example.campingwithcompose.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val navigationManager: NavigationManager

) : ViewModel() {

    fun navigateToLogin() {
        viewModelScope.launch {
            navigationManager.navigate(Screens.Login)
        }
    }


}