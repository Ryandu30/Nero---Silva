package com.example.nerosilva.navigation

sealed class Screen (val route: String){
    data object Login : Screen("login")
    data object SignPage : Screen("signpage")
    data object Home : Screen("home")
    data object Farm : Screen("farm")
    data object Marketplace : Screen("marketplace")
    data object Chatbot : Screen("chatbot")
    data object Seller : Screen("seller")
}