package com.example.nerosilva.presentation.screen.home.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.ui.unit.sp
import com.example.nerosilva.R

// ----- Content Section -----
@Composable
fun ContentSection(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF5EB))
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Bagian Gambar Utama
            MainImageSection()

            // Deskripsi
            ContentDescription()

            // Materi Berikutnya
            NextMaterials()
        }
    }
}

@Composable
fun ContentDescription() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hidroponik Fundamental Perkenalan",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Deskripsi singkat ae. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua...",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Aksi ke Modul */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784)),
            modifier = Modifier
                .height(48.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Text(
                text = "Modul",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun NextMaterials() {
    Text(
        text = "Materi berikutnya",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        HydroponicCard(
            title = "Hidroponik Fundamental Perkenalan part 2",
            imageRes = R.drawable.hidroponik_1
        )
        HydroponicCard(
            title = "Teknik Menanam Hidroponik",
            imageRes = R.drawable.hidroponik_1
        )
    }
}

// ----- UI Components -----
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderSection() {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /* Handle back button click */ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.hidroponik_1),
                    contentDescription = "Nero Silva Icon",
                    modifier = Modifier
                        .width(75.dp)
                        .height(40.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Handle bell click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "Notification",
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = { /* Handle user click */ }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "User",
                    modifier = Modifier.size(35.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFEAF5EB)
        )
    )
}

@Composable
fun MainImageSection() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.hidroponik_2),
            contentDescription = "Main Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Icon(
            painter = painterResource(id = R.drawable.hidroponik_1),
            contentDescription = "Play Icon",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
fun HydroponicCard(title: String, imageRes: Int) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}