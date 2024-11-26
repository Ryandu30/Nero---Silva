package com.example.nerosilva.presentation.screen.farm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.nerosilva.R
import com.example.nerosilva.navigation.Screen
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FarmPage(modifier: Modifier = Modifier, navController: NavController) {
    HydroponicBackground()

    Column(
        modifier = Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CalendarSection(navController = navController)
        WeatherSection()
        DailyActivitySection()
    }
}

@Composable
fun HydroponicBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFD7EAE3),
                        Color(0xFFF4EDE2)
                    )
                )
            )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarSection(navController: NavController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFA7D7C5)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    selectedDate = selectedDate.minusMonths(1)
                }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Bulan sebelumnya"
                    )
                }
                Text(
                    text = selectedDate.format(DateTimeFormatter.ofPattern("MMMM")),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                IconButton(onClick = {
                    selectedDate = selectedDate.plusMonths(1)
                }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Bulan berikutnya"
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {  navController.navigate(Screen.Calender.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C8D89))
                ) {
                    Text("Lihat Selengkapnya", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun WeatherSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFA7D7C5)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(11.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.cloud),
                    contentDescription = "Cuaca"
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Cuaca Hari Ini",
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.weather),
                    contentDescription = "Hujan",
                    modifier = Modifier.size(95.dp)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "28°C",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Heavy Rain",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Text(
                text = "Informasi",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Anda belum mempunyai rencana perkebunan!",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun DailyActivitySection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xF4F9F4)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Kegiatan Harian",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Kegiatan Harian",
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Kegiatan Hari Ini",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Membersihkan bagian yang mulai ditumbuhi lumut, dengan menggunakan air bersih dan mengalir",
                        style = MaterialTheme.typography.labelSmall
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        MulaiBerkebunButton()
                    }
                }
            }
        }
    }
}

@Composable
fun MulaiBerkebunButton() {
    var showPopup by remember { mutableStateOf(false) }

    Button(onClick = { showPopup = true }) {
        Text("Mulai Berkebun")
    }

    if (showPopup) {
        Dialog(onDismissRequest = { showPopup = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Rencana Perkebunan",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Button(onClick = { showPopup = false }) {
                        Text("Tutup")
                    }
                }
            }
        }
    }
}