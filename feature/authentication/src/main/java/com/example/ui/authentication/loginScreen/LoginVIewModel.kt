package com.example.ui.authentication.loginScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campingwithcompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val navigationManager: NavigationManager

) : ViewModel() {

    fun navigateForgetPassword() {
        viewModelScope.launch {
            navigationManager.navigate(Authentication.ForgetPassword)
        }
    }

}