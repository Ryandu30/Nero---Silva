package com.example.nerosilva.presentation.screen.farm.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CalendarPage(modifier: Modifier = Modifier, navController: NavController) {
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

        CalendarGrid()
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
        IconButton(onClick = {  }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown",
                tint = Color(0xFF004D40)
            )
        }
    }
}

@Composable
fun CalendarGrid() {
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
                                if (date == "19") Color(0xFFDFF7E9)
                                else Color.White
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (date.isNotEmpty()) {
                            Text(
                                text = date,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Color(0xFF004D40),
                                    fontWeight = if (date == "19") FontWeight.Bold else FontWeight.Normal
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
fun DailyActivitySection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEAF5EB))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header Ikon dan teks
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Kegiatan Harian",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFF66BB6A)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Kegiatan Harian",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFF004D40),
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // Konten utama
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFDFF7E9))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Panen Hasil Perkebunan",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color(0xFF66BB6A),
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Selamat, Anda telah menyelesaikan perkebunan hidroponik dengan 100 tanaman Selada! Nikmati hasil panen Anda atau jual di marketplace.",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFF004D40),
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }

            // Tombol aksi
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Mau berkebun lagi? Ayo bikin rencana berkebun hidroponik.",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFF004D40),
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(48.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5C8D89),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Mulai Berkebun Lagi",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}