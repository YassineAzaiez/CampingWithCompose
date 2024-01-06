package com.example.ui.authentication.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campingwithcompose.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val navigationManager: NavigationManager

) : ViewModel() {

    fun onRegisterClicked() {
        viewModelScope.launch {
            //TODO the screen route to be changed
            navigationManager.navigate(Authentication.ForgetPassword)
        }
    }

}