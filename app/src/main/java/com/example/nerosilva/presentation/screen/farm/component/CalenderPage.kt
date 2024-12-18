package com.example.nerosilva.presentation.screen.farm.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nerosilva.navigation.Screen
import com.example.nerosilva.presentation.screen.farm.MulaiBerkebunButton

@Composable
fun CalendarPage(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFEAF5EB),
                        Color.White
                    )
                )
            )
            .padding(16.dp)
    ) {
        CalendarHeader(month = "Oktober", year = "2024")

        Spacer(modifier = Modifier.height(12.dp))

        CalendarGrid(navController)

        Spacer(modifier = Modifier.height(12.dp))

        DailyActivity()
    }
}

@Composable
fun CalendarHeader(month: String, year: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$month $year",
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color(0xFF004D40),
                fontWeight = FontWeight.Bold
            )
        )
        IconButton(onClick = { /* TODO: Add dropdown action */ }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown",
                tint = Color(0xFF004D40)
            )
        }
    }
}

@Composable
fun CalendarGrid(navController: NavHostController) {
    val daysOfWeek = listOf("Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Min")
    val calendarData = listOf(
        listOf("", "", "", "1", "2", "3", "4"),
        listOf("5", "6", "7", "8", "9", "10", "11"),
        listOf("12", "13", "14", "15", "16", "17", "18"),
        listOf("19", "20", "21", "22", "23", "24", "25"),
        listOf("26", "27", "28", "29", "30", "31", "")
    )

    // Header hari
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        daysOfWeek.forEach { day ->
            Text(
                text = day,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFF004D40),
                textAlign = TextAlign.Center
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Grid tanggal
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        calendarData.forEach { week ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                week.forEach { date ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (date == "30") Color(0xFFDFF7E9)
                                else Color.White
                            )
                            .clickable() {
                                navController.navigate("calender_detail/$date")
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        if (date.isNotEmpty()) {
                            Text(
                                text = date,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Color(0xFF004D40),
                                    fontWeight = if (date == "30") FontWeight.Bold else FontWeight.Normal
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DailyActivity() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF4F9F4)) // Sesuai desain
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Section
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Kegiatan Harian",
                    tint = Color(0xFF5C8D89), // Warna ikon
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Kegiatan Harian",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFF212121), // Warna teks sesuai desain
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // Card untuk Kegiatan
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)) // Putih sesuai desain
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Kegiatan Hari Ini",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xB217181D),
                        )
                    )
                    Text(
                        text = "Membersihkan bagian yang mulai ditumbuhi lumut dengan menggunakan air bersih dan mengalir.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0x9917181D),
                        )
                    )
                }
            }
        }
    }
}