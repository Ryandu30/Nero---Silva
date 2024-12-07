package com.example.nerosilva.presentation.screen.home

import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nerosilva.R
import com.example.nerosilva.navigation.Screen

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFD7EAE3),
                        Color(0xFFF4EDE2)
                        )
                    )
                )
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp) // Jarak antar bagian
    ) {
        // Header
        item {
            Text(
                text = "Mulai kebun hidroponikmu sekarang 🌱",
                style = TextStyle (
                    color = Color(0xFF004D40),
                    fontWeight = FontWeight(600),
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(start = 24.dp, top = 16.dp)
            )
        }

        // Kartu utama (CTA)
        item {
            HydroponicCard(navController)
        }

        // Rekomendasi edukasi header
        item {
            Text(
                text = "Rekomendasi Edukasi",
                style = TextStyle (
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF004D40)
                ),
                modifier = Modifier.padding(start = 12.dp, bottom = 6.dp, top = 6.dp)
            )
        }

        // Kartu edukasi
        items(listOf(
            "Hidroponik Fundamental" to R.drawable.sayuran,
            "Teknik Menanam Hidroponik" to R.drawable.sayuran,
        )) { (title, imageResId) ->
            FundamentalCard(
                title = title,
                onMoreClick = { /* Tambahkan aksi */ },
                imageResId = imageResId
            )
        }
    }
}

@Composable
fun HydroponicCard(navController: NavController) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .width(371.dp)
            .height(163.dp)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Siap untuk memulai berkebun hari ini?",
                    style = TextStyle (
                        color = Color(0xFF004D40),
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(
                    onClick = { navController.navigate(Screen.Farm.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688))
                ) {
                    Text(text = "Mulai Berkebun", color = Color.White)
                }
            }

            Image(
                painter = painterResource(id = R.drawable.layer1),
                contentDescription = "Hidroponik Image",
                modifier = Modifier
                    .size(140.dp)
            )
        }
    }
}

@Composable
fun FundamentalCard(
    title: String,
    onMoreClick: () -> Unit,
    imageResId: Int
) {
    Card(
        shape = RoundedCornerShape(20.dp), // Sudut melengkung
        elevation = CardDefaults.cardElevation(4.dp), // Efek bayangan
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(371.dp)
            .height(199.dp)
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Gambar di bagian atas
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Hydroponic Image",
                modifier = Modifier
                    .width(337.dp)
                    .height(136.dp)
                    .padding(start = 14.dp, end = 6.dp, top = 12.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)), // Melengkung hanya di bagian atas
                contentScale = ContentScale.Crop // Sesuaikan skala gambar
            )
            // Teks dan tombol di bagian bawah
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Judul
                Text(
                    text = title,
                    style = TextStyle (
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        color = Color(0xFF212121)
                    )
                )
                // Tombol "Selengkapnya"
                TextButton(onClick = onMoreClick) {
                    Text(
                        text = "Selengkapnya >>",
                        style = TextStyle (
                            color = Color(0xFF757575),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun EducationalCard(title: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                style = TextStyle (
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF004D40)
                )
            )

            Image(
                painter = painterResource(id = R.drawable.sayuran),
                contentDescription = "Educational Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}