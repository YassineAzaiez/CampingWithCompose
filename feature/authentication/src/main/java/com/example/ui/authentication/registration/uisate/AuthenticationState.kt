package com.example.ui.authentication.registration.uisate

class RegistrationState(
    val emailAddress: String = "",
    val password: String = "",
    val phone: String = "",
    val name: String = "",
    val isRegistrationContentValid: Boolean = false,
    val isLoading: Boolean = false,
    val emailAddressError: String = "",
    val passwordError: String = "",
    val nameError: String = "",

    ) {

    companion object {
        fun initialise(): RegistrationState = RegistrationState()
    }

    fun build(block: Builder.() -> Unit) = Builder(this).apply(block).build()

    class Builder(state: RegistrationState) {
        var userEmail = state.emailAddress
        var userPassword = state.password
        val phone: String = state.phone
        val name: String = state.name
        val isRegistrationContentValid = true
        var loading = state.isLoading
        var emailAddressError: String = ""
        var passwordError: String = ""
        var nameError: String = ""


        fun build(): RegistrationState {
            return RegistrationState(
                userEmail,
                userPassword,
                phone,
                name,
                isRegistrationContentValid,
                loading,
                emailAddressError,
                passwordError,
                nameError

            )
        }
    }
}