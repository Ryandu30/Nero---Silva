package com.example.nerosilva.utils

import com.example.nerosilva.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Farm.route,
    )
}