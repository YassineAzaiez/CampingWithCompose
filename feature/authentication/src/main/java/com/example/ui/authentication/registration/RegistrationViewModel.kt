package com.example.ui.authentication.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campingwithcompose.navigation.NavigationManager
import com.example.ui.authentication.registration.uisate.RegistrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val navigationManager: NavigationManager

) : ViewModel() {

    private val _uiState = MutableStateFlow(RegistrationState())
    val uiState: StateFlow<RegistrationState> = _uiState

    fun onRegisterClicked() {
        viewModelScope.launch {
            //TODO the screen route to be changed
            navigationManager.navigate(Authentication.ForgetPassword)
        }
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            //TODO the screen route to be changed
            navigationManager.navigate(Authentication.Login)
        }
    }

}