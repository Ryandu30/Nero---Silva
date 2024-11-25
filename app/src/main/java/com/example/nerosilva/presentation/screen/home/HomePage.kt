package com.example.nerosilva.presentation.screen.home

import androidx.activity.ComponentActivity
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nerosilva.R

@Composable
fun HomePage(modifier: Modifier, navController: NavController) {
    // Tambahkan background hijau muda ke seluruh layar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEAF5EB)) // Background ditambahkan
            .padding(16.dp)
    ) {
        // Header Section
        Text(
            text = "Mulai kebun hidroponikmu sekarang 🌱",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF004D40),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Main CTA Section
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Siap untuk Memulai berkebun hari ini?",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* TODO: Add action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688))
                ) {
                    Text(text = "Mulai Berkebun", color = Color.White)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Educational Recommendations Section
        Text(
            text = "Rekomendasi Edukasi",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF004D40),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize() // Menyesuaikan LazyColumn dengan layar
        ) {
            items(listOf("Hidroponik Fundamental", "Teknik Menanam Hidroponik")) { title ->
                EducationalCard(title = title)
            }
        }
    }
}

@Composable
fun EducationalCard(title: String, imageResId: Int = R.drawable.image) {
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
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Teks "Rekomendasi Edukasi" dengan efek bold dan 3D
            Text(
                text = "Hidroponik Fundamental",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold // Membuat teks lebih bold
                ),
                color = Color(0xFF004D40), // Warna hijau gelap
                modifier = Modifier
                    .shadow(4.dp, shape = RoundedCornerShape(8.dp)) // Efek bayangan 3D
                    .background(
                        color = Color.White, // Warna latar belakang putih
                        shape = RoundedCornerShape(8.dp) // Sudut melengkung
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp) // Padding internal

            )

            // Gambar besar di bawah teks
            Image(
                painter = painterResource(id = R.drawable.sayuran),
                contentDescription = "Educational Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) // Ukuran gambar lebih besar
                    .clip(RoundedCornerShape(6.dp))
                    .border(2.dp, Color(0xFF004D40), RoundedCornerShape(6.dp))
            )

            // Teks judul di bawah gambar
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color(0xFF004D40),
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}