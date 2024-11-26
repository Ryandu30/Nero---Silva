package com.example.nerosilva.presentation.screen.farm.component

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

import com.example.nerosilva.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CalendarPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Sesuaikan hanya lebar, bukan tinggi
            .background(brush = Brush.verticalGradient(colors = listOf(Color(0xFFEAF5EB), Color.White)))
            .padding(16.dp)
    ) {
        // Header bulan dan tahun
        CalendarHeader(month = "Oktober", year = "2024")

        Spacer(modifier = Modifier.height(8.dp))

        // Grid kalender
        CalendarGrid()
    }
}


@Composable
fun CalendarHeader(month: String, year: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
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
        IconButton(onClick = { /* Handle dropdown */ }) {
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
    val daysOfWeek = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
    val calendarData = listOf(
        listOf("", "", "", "1", "2", "3", "4"),
        listOf("5", "6", "7", "8", "9", "10", "11"),
        listOf("12", "13", "14", "15", "16", "17", "18"),
        listOf("19", "20", "21", "22", "23", "24", "25"),
        listOf("26", "27", "28", "29", "30", "31", "")
    )

    // Header hari
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        daysOfWeek.forEach { day ->
            Text(
                text = day,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF004D40),
                modifier = Modifier.weight(1f)
            )
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Grid tanggal
    Column {
        calendarData.forEach { week ->
            Row(
                modifier = Modifier.fillMaxWidth(),
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
                                if (date == "19") Color(0xFFE0F2F1) // Highlight untuk tanggal tertentu
                                else Color.White
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (date.isNotEmpty()) {
                            Text(
                                text = date,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFF004D40)
                            )
                            val events = mapOf(
                                "10" to "Perawatan",
                                "16" to "Perawatan",
                                "19" to "Event Khusus",
                                "30" to "Panen"
                            )

                            Box(
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .padding(4.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        if (events.containsKey(date)) {
                                            Color(0xFFEAF5EB) // Warna khusus untuk tanggal dengan event
                                        } else Color.White
                                    )
                                    .border(1.dp, Color(0xFFB0BEC5)),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = date,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color(0xFF004D40)
                                    )
                                    events[date]?.let { event ->
                                        Text(
                                            text = event,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = Color(0xFF004D40)
                                        )
                                    }
                                }
                            }

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
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEAF5EB) // Warna latar hijau muda
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header: Ikon dan Teks "Kegiatan Harian"
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Kegiatan Harian",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFF66BB6A) // Warna ikon hijau
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

            // Konten utama: "Panen Hasil Perkebunan"
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
                        text = "Selamat anda telah menyelesaikan perkebunan hidroponik dengan 100 tanaman Selada. Nikmati hasil panen Anda atau bisa Anda jual di marketplace.",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFF004D40),
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }

            // Footer: Tombol "Mulai Berkebun Lagi"
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Mau berkebun lagi?\nAyo bikin rencana berkebun hidroponik.",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFF004D40),
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Tombol seperti pada gambar
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(45.dp), // Tinggi tombol sesuai
                    shape = RoundedCornerShape(10.dp), // Membuat sisi lebih membulat
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5C8D89), // Warna tombol
                        contentColor = Color(0xFFFFFFFF) // Warna teks
                    )
                ) {
                    Text(
                        text = "Mulai Berkebun Lagi",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp // Menyesuaikan ukuran teks
                        )
                    )
                }
            }
        }
    }
}