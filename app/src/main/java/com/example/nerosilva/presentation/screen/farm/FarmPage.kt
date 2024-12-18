package com.example.nerosilva.presentation.screen.farm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nerosilva.R
import com.example.nerosilva.navigation.Screen
//import com.example.nerosilva.presentation.screen.farm.component.DailyActivitySection
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FarmPage(modifier: Modifier = Modifier, navController: NavController) {
        HydroponicBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CalendarSection(navController = navController)
            WeatherSection()
            DailyActivitySection(navController)
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
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center // Center the text horizontally
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

            // Centering the Date and Day
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                verticalArrangement = Arrangement.Center // Center vertically
            ) {
                Text(
                    text = selectedDate.format(DateTimeFormatter.ofPattern("EEEE")),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center // Center the text
                )
                Text(
                    text = selectedDate.format(DateTimeFormatter.ofPattern("d MMMM")),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center // Center the text
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Center horizontally
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
fun DailyActivitySection(navController: NavController) {
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
                        MulaiBerkebunButton(navController) // Panggil tombol
                    }
                }
            }
        }
    }
}

@Composable
fun MulaiBerkebunButton(navController: NavController) {
    var showPopup1 by remember { mutableStateOf(false) }
    var showPopup2 by remember { mutableStateOf(false) }

    Button(
        onClick = { showPopup1 = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF5C8D89) // Warna tombol kuning sesuai desain
        ),
        shape = RoundedCornerShape(12.dp) // Membuat tombol lebih elegan
    ) {
        Text(
            text = "Mulai Berkebun",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
    }

    // Popup pertama
    if (showPopup1) {
        Dialog(onDismissRequest = { showPopup1 = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Rencana Perkebunan",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF212121)
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    // Jenis Tanaman
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Jenis Tanaman*",
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(35.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            listOf("Selada", "Kangkung").forEach { item ->
                                CheckboxWithLabel(item)
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(34.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            listOf("Bayam", "Tomat").forEach { item ->
                                CheckboxWithLabel(item)
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(46.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            listOf("Sawi", "Strawberry").forEach { item ->
                                CheckboxWithLabel(item)
                            }
                        }
                    }

                    // Dropdown untuk metode hidroponik
                    var selectedMethod by remember { mutableStateOf("") }
                    DropdownMenu(selectedMethod, listOf("Wick System")) { selectedMethod = it }

                    // Jumlah Tanaman
                    var jumlahTanaman by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = jumlahTanaman,
                        onValueChange = { jumlahTanaman = it },
                        label = { Text("Jumlah Tanaman*") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Tombol Simpan Data
                    Button(
                        onClick = {
                            showPopup1 = false
                            showPopup2 = true
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C8D89)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Simpan Data", color = Color.White)
                    }
                }
            }
        }
    }

    // Popup kedua
    if (showPopup2) {
        Dialog(onDismissRequest = { showPopup2 = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Apa saja yang harus dipersiapkan?",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF212121)
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    // Persiapan (Checkbox)
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf(
                            "100 biji benih selada",
                            "Alat",
                            "dll",
                            "dll"
                        ).forEach { item ->
                            CheckboxWithLabel(item)
                        }
                    }

                    // Tombol Mulai Berkebun
                    Button(
                        onClick = {
                            showPopup2 = false
                            navController.navigate(Screen.Calender.route)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C8D89)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Mulai Berkebun", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun CheckboxWithLabel(label: String) {
    var checked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF259571) // Ganti warna checkbox saat tercentang
            )
        )
        Text(label)
    }
}

@Composable
fun MulaiBerkebunButtons() {
    var showPopup1 by remember { mutableStateOf(false) }
    var showPopup2 by remember { mutableStateOf(false) }

    Button(
        onClick = { showPopup1 = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF5C8D89) // Warna tombol kuning sesuai desain
        ),
        shape = RoundedCornerShape(12.dp) // Membuat tombol lebih elegan
    ) {
        Text(
            text = "Mulai Berkebun",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
    }

    // Popup pertama
    if (showPopup1) {
        Dialog(onDismissRequest = { showPopup1 = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Rencana Perkebunan",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF212121)
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    // Jenis Tanaman
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Jenis Tanaman*",
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(35.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            listOf("Selada", "Kangkung").forEach { item ->
                                CheckboxWithLabel(item)
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(34.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            listOf("Bayam", "Tomat").forEach { item ->
                                CheckboxWithLabel(item)
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(46.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            listOf("Sawi", "Strawberry").forEach { item ->
                                CheckboxWithLabel(item)
                            }
                        }
                    }

                    // Dropdown untuk metode hidroponik
                    var selectedMethod by remember { mutableStateOf("") }
                    DropdownMenu(selectedMethod, listOf("Wick System")) { selectedMethod = it }

                    // Jumlah Tanaman
                    var jumlahTanaman by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = jumlahTanaman,
                        onValueChange = { jumlahTanaman = it },
                        label = { Text("Jumlah Tanaman*") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Tombol Simpan Data
                    Button(
                        onClick = {
                            showPopup1 = false
                            showPopup2 = true
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C8D89)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Simpan Data", color = Color.White)
                    }
                }
            }
        }
    }

    // Popup kedua
    if (showPopup2) {
        Dialog(onDismissRequest = { showPopup2 = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Apa saja yang harus dipersiapkan?",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF212121)
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    // Persiapan (Checkbox)
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf(
                            "100 biji benih selada",
                            "Alat",
                            "dll",
                            "dll"
                        ).forEach { item ->
                            CheckboxWithLabel(item)
                        }
                    }

                    // Tombol Mulai Berkebun
                    Button(
                        onClick = {
                            showPopup2 = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C8D89)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Mulai Berkebun", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun DropdownMenu(
    selectedItem: String,
    items: List<String>,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            label = { Text("Pilih metode tanam") },
            trailingIcon = {
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    Modifier.clickable { expanded = true }
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

//@Composable
//fun DailyActivitySection(viewModel: PlanViewModel = hiltViewModel()) {
//    val plants by viewModel.plants.collectAsState(initial = emptyList())
//    val isLoading by viewModel.isLoading.collectAsState(initial = false)
//    val errorMessage = when (val currentState = viewModel.state.collectAsState().value) {
//        is PlanViewModel.PlanState.Error -> currentState.message
//        else -> null
//    }
//
//    var selectedPlantId by remember { mutableStateOf("") }
//    var plantCount by remember { mutableStateOf("") }
//
//    val snackbarHostState = remember { SnackbarHostState() }
//    val scope = rememberCoroutineScope()
//
//    Scaffold(
//        snackbarHost = { SnackbarHost(snackbarHostState) }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .padding(paddingValues)
//                .fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            // Bagian untuk memilih tanaman
//            Text(
//                text = "Pilih tanaman:",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF212121), // Sama seperti di kode pertama
//                modifier = Modifier.align(Alignment.Start) // Rata kiri
//            )
//
//            // Menampilkan loading state atau pesan jika tidak ada tanaman
//            if (isLoading) {
//                CircularProgressIndicator(
//                    modifier = Modifier.align(Alignment.CenterHorizontally)
//                )
//            } else if (plants.isEmpty()) {
//                Text("Tidak ada data tanaman", color = Color.Gray, modifier = Modifier.align(Alignment.CenterHorizontally))
//            } else {
//                // Menampilkan daftar tanaman dengan tombol
//                plants.forEach { plant ->
//                    Button(
//                        onClick = { selectedPlantId = plant.id },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 8.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color(0xFFF5C8D89) // Warna tombol kuning seperti di kode pertama
//                        ),
//                        shape = RoundedCornerShape(12.dp) // Bentuk tombol yang lebih elegan
//                    ) {
//                        Text(
//                            text = plant.name,
//                            style = TextStyle(
//                                color = Color.White,
//                                fontWeight = FontWeight.Bold
//                            )
//                        )
//                    }
//                }
//            }
//
//            // Input jumlah tanaman
//            OutlinedTextField(
//                value = plantCount,
//                onValueChange = { plantCount = it },
//                label = { Text("Jumlah Tanaman*") },
//                isError = plantCount.isEmpty(),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 8.dp),
//            )
//
//            // Tombol Simpan Data
//            Button(
//                onClick = {
//                    if (selectedPlantId.isEmpty()) {
//                        scope.launch { snackbarHostState.showSnackbar("Pilih tanaman terlebih dahulu") }
//                        return@Button
//                    }
//                    if (plantCount.isEmpty()) {
//                        scope.launch { snackbarHostState.showSnackbar("Masukkan jumlah tanaman") }
//                        return@Button
//                    }
//                    viewModel.createPlan("token", "user_id", selectedPlantId, plantCount)
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C8D89)),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.CenterHorizontally)
//                    .padding(top = 16.dp),
//                shape = RoundedCornerShape(12.dp) // Bentuk tombol yang lebih elegan
//            ) {
//                Text("Simpan Data", color = Color.White)
//            }
//        }
//    }
//
//    // Menangani error message
//    LaunchedEffect(errorMessage) {
//        errorMessage?.let {
//            scope.launch {
//                snackbarHostState.showSnackbar(it)
//            }
//        }
//    }
//}
