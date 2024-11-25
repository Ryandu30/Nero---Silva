package com.example.nerosilva.presentation.screen.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar() {
    var selectedIndex by remember { mutableStateOf(0) }

    NavigationBar(
        containerColor = Color(0xFFEAF5EB), // Warna latar navbar
        contentColor = Color(0xFF004D40),
        modifier = Modifier.fillMaxWidth()
    ) {
        val items = listOf(
            NavigationItem("home", Icons.Default.Home),
            NavigationItem("Plan", Icons.Default.DateRange),
            NavigationItem("Profile", Icons.Default.Person)
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (selectedIndex == index) Color(0xFF00796B) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (selectedIndex == index) Color(0xFF00796B) else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFB2DFDB)
                )
            )
        }
    }
}

data class NavigationItem(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)