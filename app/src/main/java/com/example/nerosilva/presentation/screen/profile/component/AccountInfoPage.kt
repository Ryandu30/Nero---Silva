import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AccountInfoPage(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF5EB)) // Background warna lembut
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Judul Profil
            Text(
                text = "Profil",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Kartu Profil dengan Input Data
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF4F9F4), RoundedCornerShape(50.dp)) // Warna putih untuk kartu
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Avatar
                    Box(
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color(0xFFD9D9D9), CircleShape) // Warna abu-abu untuk avatar
                        )
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Icon",
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.BottomEnd),
                            tint = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Nama Pengguna
                    Text(
                        text = "Kipli Kurniawan",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Form Input Data
                    ProfileInputField("Nama Lengkap")
                    ProfileInputField("Username")
                    ProfileInputField("Email")
                    ProfileInputField("Nomor Telepon")
                    ProfileInputField("Alamat")
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ProfileInputField(label: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFFDADADA), RoundedCornerShape(8.dp)) // Warna abu terang untuk kolom input
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Isi $label", // Placeholder untuk kolom input
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}