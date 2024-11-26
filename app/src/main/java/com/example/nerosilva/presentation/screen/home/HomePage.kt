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
fun HomePage(modifier: Modifier = Modifier, navController: NavController) {
    // Layar dengan latar belakang hijau muda
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEAF5EB))
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Mulai kebun hidroponikmu sekarang 🌱",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color(0xFF004D40),
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Kartu utama (CTA)
        HydroponicCard()

        Spacer(modifier = Modifier.height(24.dp))

        // Rekomendasi edukasi
        Text(
            text = "Rekomendasi Edukasi",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40)
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Daftar edukasi
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(listOf("Hidroponik Fundamental", "Teknik Menanam Hidroponik")) { title ->
                EducationalCard(title = title)
            }
        }
    }
}

@Composable
fun HydroponicCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Siap untuk memulai berkebun hari ini?",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFF004D40),
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Button(
                    onClick = { /* Aksi */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688))
                ) {
                    Text(text = "Mulai Berkebun", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.hidroponik_1),
                contentDescription = "Hidroponik Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(2.dp, Color(0xFF004D40), RoundedCornerShape(12.dp))
            )
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
                style = MaterialTheme.typography.titleMedium.copy(
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
                    .border(2.dp, Color(0xFF004D40), RoundedCornerShape(8.dp))
            )
        }
    }
}