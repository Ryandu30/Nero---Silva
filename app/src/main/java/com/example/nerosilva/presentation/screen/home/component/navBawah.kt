package com.example.nerosilva.presentation.screen.home.component

import android.os.Bundle
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nerosilva.R

@Composable
fun FundamentalCard(
    title: String,
    onMoreClick: () -> Unit,
    imageResId: Int
) {
    Card(
        shape = RoundedCornerShape(16.dp), // Sudut melengkung
        elevation = CardDefaults.cardElevation(4.dp), // Efek bayangan
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp) // Jarak antar card
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Gambar di bagian atas
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Hydroponic Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
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
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF212121)
                    )
                )
                // Tombol "Selengkapnya"
                TextButton(onClick = onMoreClick) {
                    Text(
                        text = "Selengkapnya >>",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color(0xFF757575)
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FundamentalCardPreview() {
    MaterialTheme {
        FundamentalCard(
            title = "Hidroponik Fundamental",
            onMoreClick = { /* Handle click */ },
            imageResId = R.drawable.sayuran // Pastikan resource gambar sesuai
        )
    }
}



