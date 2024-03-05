package com.example.campingwithcompsoe.common.utils

object ValidationUtils {
    fun isNumber(value: String): Boolean {
        return value.isEmpty() || Regex("^\\d+\$").matches(value)
    }

    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$")
        return emailRegex.matches(email)
    }

    fun isValidFullName(fullName: String): Boolean {
        val nameRegex = Regex("""^[A-Z][a-zA-Z]*( [A-Z][a-zA-Z]*)*$""")

        return fullName.matches(nameRegex) && fullName.length >= 2
    }

    fun isPasswordValid(password: String): Boolean {
        val hasDigit = password.any(Char::isDigit)
        val hasLetter = password.any(Char::isLetter)
        val hasSpecialChar = password.any { !it.isLetterOrDigit() }
        val hasUpperCase = password.any(Char::isUpperCase)
        val isValidLength = password.length >= 8

        return hasDigit && hasLetter && hasSpecialChar && hasUpperCase && isValidLength
    }

}