package com.example.nerosilva.presentation.screen.farm.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nerosilva.R

// Mock data untuk cardItems
data class CardItem(val title: String, val imageRes: Int, val route: String)

val cardItems = listOf(
    CardItem("Media Tanam", R.drawable.hidroponik_1, "media_tanam"),
    CardItem("Nutrisi", R.drawable.hidroponik_2, "nutrisi"),
    CardItem("Teknik Dasar", R.drawable.hidroponik_1, "teknik_dasar"),
    CardItem("Sistem Hidroponik", R.drawable.hidroponik_2, "sistem_hidroponik")
)

@Composable
fun DetailPage(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEAF5EB))
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        MainImageSection()
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Hidroponik Fundamental",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Hidroponik Fundamental adalah Pondasi untuk melakukan penanaman tanaman hidroponik yang meliputi berbagai aspek",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    items(cardItems.chunked(2)) { rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            rowItems.forEach { cardItem ->
                                HydroponicCard(
                                    title = cardItem.title,
                                    imageRes = cardItem.imageRes,
                                    onClick = {
                                        navController.navigate(cardItem.route) // Navigasi ke rute yang diinginkan
                                    }
                                )
                            }
                            if (rowItems.size < 2) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun HydroponicCard(title: String, imageRes: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .clickable { onClick() } // Menambahkan klik di elemen luar
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun MainImageSection() {
    Image(
        painter = painterResource(id = R.drawable.hidroponik_1), // Placeholder image
        contentDescription = "Main Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}