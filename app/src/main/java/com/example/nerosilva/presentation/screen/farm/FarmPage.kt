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
import androidx.compose.ui.text.TextStyle
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
                        Color(0xFFF4EDE2),
                        Color(0xFFD7EAE3)
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
            .padding(top = 20.dp, end = 24.dp, bottom = 8.dp, start = 24.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA7D7C5)) // Warna latar belakang hijau pastel
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Bagian Navigasi Bulan
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    selectedDate = selectedDate.minusMonths(1)
                }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Bulan sebelumnya",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(
                    text = selectedDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                IconButton(onClick = {
                    selectedDate = selectedDate.plusMonths(1)
                }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Bulan berikutnya",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp)) // Jarak antara bagian bulan dan hari/tanggal

            // Bagian Hari dan Tanggal
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val dayOfWeek = selectedDate.format(DateTimeFormatter.ofPattern("EEEE")) // Hari
                val dayOfMonth = selectedDate.format(DateTimeFormatter.ofPattern("d")) // Tanggal
                val month = selectedDate.format(DateTimeFormatter.ofPattern("MMMM")) // Bulan

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = dayOfWeek, // Menampilkan nama hari
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "$dayOfMonth $month", // Menampilkan tanggal lengkap
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp)) // Jarak antara hari/tanggal dan tombol lihat selengkapnya

            // Tombol Lihat Selengkapnya
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate(Screen.Calender.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4F9F4)), // Warna tombol terang
                    shape = RoundedCornerShape(12.dp), // Sudut membulat
                    modifier = Modifier
                        .height(44.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Lihat Selengkapnya",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400)
                    )
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
            .padding(horizontal = 24.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF4F9F4)), // Warna hijau pastel sesuai desain
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            // Header Cuaca
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.cloud),
                    contentDescription = "Cuaca",
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Cuaca Hari Ini",
                    style = TextStyle (
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xB217181D),

                        )
                )
            }

            // Informasi Cuaca
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.weather),
                    contentDescription = "Hujan",
                    modifier = Modifier.size(96.dp)
                )
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "28°C",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            color = Color(0xFF212121), // Warna teks suhu
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Heavy Rain",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color(0xFF757575)
                        )
                    )
                }
            }

            // Informasi Rencana
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Informasi",
                    style = TextStyle (
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xB217181D),
                    )
                )
                Text(
                    text = "Anda belum mempunyai rencana perkebunan!",
                    style = TextStyle (
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(300),
                        color = Color(0xB217181D),

                        )
                )
            }
        }
    }
}


@Composable
fun DailyActivitySection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
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
                        text = "Anda belum mempunyai agenda harian!",
                        style = TextStyle (
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xB217181D),
                            )
                    )
                    Text(
                        text = "Silahkan tambahkan data perencanaan anda terlebih dahulu, Tekan tombol dan mulai untuk berkebun.",
                        style = TextStyle (
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0x9917181D),
                            )
                    )

                    // Tombol Mulai Berkebun
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        MulaiBerkebunButton() // Panggil tombol
                    }
                }
            }
        }
    }
}

@Composable
fun MulaiBerkebunButton() {
    var showPopup by remember { mutableStateOf(false) }

    Button(
        onClick = { showPopup = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF5C8D89) // Warna tombol kuning sesuai desain
        ),
        shape = RoundedCornerShape(12.dp) // Membuat tombol lebih elegan
    ) {
        Text(
            text = "Mulai Berkebun",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
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
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF212121)
                        )
                    )
                    Button(
                        onClick = { showPopup = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C8D89))
                    ) {
                        Text("Tutup", color = Color.White)
                    }
                }
            }
        }
    }
}