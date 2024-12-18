package com.example.nerosilva.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nerosilva.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(modifier: Modifier = Modifier, navController: NavController) {
    var userName = remember { mutableStateOf("User Name") } // State for user name
    var isLoggedIn = remember { mutableStateOf(true) } // State for login status

    LaunchedEffect(isLoggedIn.value) {
        if (!isLoggedIn.value) {
            navController.navigate("login") {
                popUpTo("profile") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TopAppBar with Back button
        TopAppBar(
            title = {
                Text(
                    text = "Profil",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(Screen.Home.route) { // Navigasi ke homepage
                        popUpTo("profile") { inclusive = true }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

            // Spacer fleksibel untuk mendorong elemen ke bawah layar
            Spacer(modifier = Modifier.weight(1f))

            // Kartu Profil
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF74B49B), RoundedCornerShape(16.dp)) // Hijau tua
                    .padding(18.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Avatar dengan tombol edit
                    Box(
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color(0xFFBEE3B3), CircleShape) // Hijau tua untuk avatar
                        )
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Icon",
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.BottomEnd)
                                .clickable {
                                    navController.navigate("edit_profile") // Navigasi ke halaman edit
                                },
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Nama Pengguna
                    Text(
                        text = userName.value // Displaying the actual username
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Daftar Menu
                    Column(modifier = Modifier.fillMaxWidth()) {
                        MenuItem(
                            title = "Informasi Akun",
                            icon = Icons.Default.Info,
                            onClick = { navController.navigate(Screen.Account.route) }
                        )
                        MenuItem(
                            title = "Notifikasi",
                            icon = Icons.Default.Notifications,
                            onClick = { navController.navigate("notifications") }
                        )
                        MenuItem(
                            title = "Keamanan & Privasi",
                            icon = Icons.Default.Lock,
                            onClick = { navController.navigate("privacy") }
                        )
                        MenuItem(
                            title = "Bantuan & Feedback",
                            icon = Icons.Default.Warning,
                            onClick = { navController.navigate("help_feedback") }
                        )
                        MenuItem(
                            title = "Setting",
                            icon = Icons.Default.Settings,
                            onClick = { navController.navigate("settings") }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Tombol Log Out
                        Text(
                            text = "Log Out",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    isLoggedIn.value = false // Correct way to update the value of isLoggedIn
                                }
                                .padding(vertical = 8.dp),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )

                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }

// Item menu dengan navigasi
@Composable
fun MenuItem(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }, // Handle klik menu
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White, // Ikon putih untuk kontras
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = Color.White // Teks putih untuk kontras
        )
    }
}
