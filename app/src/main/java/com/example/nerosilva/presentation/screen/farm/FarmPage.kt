package com.example.nerosilva.presentation.screen.farm

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nerosilva.R
import com.example.nerosilva.navigation.Screen
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FarmPage(modifier: Modifier = Modifier, navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        HydroponicBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CalendarSection(navController = navController)
            WeatherSection()
            DailyActivitySection()
        }
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
            .padding(horizontal = 24.dp, vertical = 8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA7D7C5))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { selectedDate = selectedDate.minusMonths(1) }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Previous Month",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(
                    text = selectedDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                IconButton(onClick = { selectedDate = selectedDate.plusMonths(1) }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Next Month",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = selectedDate.format(DateTimeFormatter.ofPattern("EEEE")),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = selectedDate.format(DateTimeFormatter.ofPattern("d MMMM")),
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate(Screen.Calender.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4F9F4)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height(44.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Lihat Selengkapnya",
                        color = Color.Black,
                        fontSize = 16.sp
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
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF4F9F4))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.cloud),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Cuaca Hari Ini",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xB217181D)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.weather),
                    contentDescription = "Weather Condition",
                    modifier = Modifier.size(96.dp)
                )
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "28°C",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF212121)
                    )
                    Text(
                        text = "Heavy Rain",
                        fontSize = 14.sp,
                        color = Color(0xFF757575)
                    )
                }
            }

            Text(
                text = "Anda belum mempunyai rencana perkebunan!",
                fontSize = 14.sp,
                color = Color(0xB217181D)
            )
        }
    }
}

@Composable
fun DailyActivitySection(viewModel: PlanViewModel = viewModel()) {
    val plants by viewModel.plants.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.error.collectAsState()

    var selectedPlantId by remember { mutableStateOf("") }
    var plantCount by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Pilih tanaman:")
                if (isLoading) {
                    CircularProgressIndicator()
                } else if (plants.isEmpty()) {
                    Text("Tidak ada data tanaman", color = Color.Gray)
                } else {
                    plants.forEach { plant ->
                        Button(onClick = { selectedPlantId = plant.id }) {
                            Text(text = plant.name)
                        }
                    }
                }

                OutlinedTextField(
                    value = plantCount,
                    onValueChange = { plantCount = it },
                    label = { Text("Jumlah Tanaman*") },
                    isError = plantCount.isEmpty()
                )

                Button(
                    onClick = {
                        if (selectedPlantId.isNotEmpty() && plantCount.isNotEmpty()) {
                            viewModel.createPlan("token", "user_id", selectedPlantId, plantCount)
                        } else {
                            scope.launch {
                                snackbarHostState.showSnackbar("Isi data dengan lengkap")
                            }
                        }
                    }
                ) {
                    Text("Simpan Data")
                }
            }
        }
    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            scope.launch {
                snackbarHostState.showSnackbar(it)
            }
        }
    }
}



