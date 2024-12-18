package com.example.nerosilva.presentation.screen.login

data class LoginState(
    val loading: Boolean = false,
    val success: String? = "",
    val error: String? = null
)
