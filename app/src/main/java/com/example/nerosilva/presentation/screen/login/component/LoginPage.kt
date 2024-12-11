package com.example.nerosilva.presentation.screen.login.component

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nerosilva.R
import com.example.nerosilva.navigation.Screen
import com.example.nerosilva.presentation.screen.login.LoginViewModel
import com.example.nerosilva.ui.theme.NeroSilvaTheme

@SuppressLint("ResourceType")
@Composable
fun LoginPage(modifier: Modifier, navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.gunung_1),
            contentDescription = "Gunung",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(453.dp)
                .height(390.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ellipse),
            contentDescription = "Matahari",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 80.dp, end = 48.dp)
                .width(50.dp)
                .height(50.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo_1),
            contentDescription = "Logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 120.dp)
                .width(163.dp)
                .height(91.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.pohon),
            contentDescription = "Pohon",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(bottom = 78.dp)
                .width(453.dp)
                .height(390.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.bg_form),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(413.dp)
                .height(600.dp)
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 300.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Log In",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.48.sp,
                    color = Color(0xFFFFFFFF)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Email",
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                modifier = Modifier
                    .padding(end = 260.dp, bottom = 10.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .width(320.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(size = 90.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF0F0F0),
                    unfocusedContainerColor = Color(0xFFF0F0F0),
                    disabledContainerColor = Color(0xFFF0F0F0),
                    focusedIndicatorColor = Color(0xFF259571),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.None
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Password",
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                modifier = Modifier
                    .padding(end = 230.dp, bottom = 10.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .width(320.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(size = 90.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF0F0F0),
                    unfocusedContainerColor = Color(0xFFF0F0F0),
                    disabledContainerColor = Color(0xFFF0F0F0),
                    focusedIndicatorColor = Color(0xFF259571),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.None
                ),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color.White,
                        uncheckedColor = Color.Black,
                        checkedColor = Color(0xFF259571)
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Remember me",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { }) {
                    Text(
                        text = "Forgot Password?",
                        fontSize = 14.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight(400)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    /*Ketika Login Jika Membuat Kondisi Pakai isNotBlank Pastikan Aplikasi Akses ViewModel
                    * saat Kondisi True. Sebelumnya Terbalik */
                    if (email.isNotBlank() && password.isNotBlank()) {
                        viewModel.loginUser(email, password) {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Login.route) {
                                    inclusive = true
                                }
                            }
                            email = ""
                            password = ""
                        }
                    } else {
                        Toast.makeText(
                            context,
                            "Email dan Password Wajib Diisi",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                },
                modifier = Modifier
                    .width(222.dp)
                    .height(48.dp)
                    .padding(horizontal = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF259571),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Log In",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "-------- Or Create With --------", modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier.size(24.dp))
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = R.drawable.facebook), contentDescription = "Facebook",
                        modifier = Modifier.size(24.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = {
                navController.navigate(Screen.Register.route)
            }) {
                Text(
                    text = "Don't have an account yet? click here!",
                    fontSize = 14.sp,
                    color = Color(0xFF000000)
                )
            }
        }
    }
}