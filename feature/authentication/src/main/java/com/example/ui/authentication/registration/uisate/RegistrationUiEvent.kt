package com.example.ui.authentication.registration.uisate

sealed class RegistrationUiEvent {
    data class EmailChanged(val email: String) : RegistrationUiEvent()
    data class PasswordChanged(val password: String) : RegistrationUiEvent()
    data class NameChanged(val password: String) : RegistrationUiEvent()
    data class VisiblePassword(val isVisiblePassword: Boolean) : RegistrationUiEvent()
    object Submit : RegistrationUiEvent()
}
