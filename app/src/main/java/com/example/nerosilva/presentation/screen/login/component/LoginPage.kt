package com.example.nerosilva.presentation.screen.login.component

import android.annotation.SuppressLint
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nerosilva.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ResourceType")
@Composable
fun LoginPage(modifier: Modifier, navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var rememberMe by remember { mutableStateOf(false) }

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

        Image(painter = painterResource(id = R.drawable.pohon),
            contentDescription = "Pohon",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(bottom = 78.dp)
                .width(453.dp)
                .height(390.dp)
        )

        Image(painter = painterResource(id = R.drawable.bg_form),
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
            Text(text = "Log In",
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                letterSpacing = 0.48.sp,
                color = Color(0xFFFFFFFF)
                )
            }

            Spacer(modifier = Modifier.height(40.dp)

            )

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
                    .height(46.dp),
                shape = RoundedCornerShape(size = 90.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    containerColor = Color(0xFFF0F0F0),
                ),
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
                    .height(46.dp),
                shape = RoundedCornerShape(size = 90.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    containerColor = Color(0xFFF0F0F0),
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    colors = CheckboxDefaults.colors(Color(0xFF259571))
                )
                Text(text = "Remember me", fontSize = 14.sp, modifier = Modifier.weight(1f))

                TextButton(onClick = {  }) {
                    Text(text = "Forgot Password?",  fontSize = 14.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(0.dp)
                    .width(153.dp)
                    .height(33.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF259571))
            ) {
                Text(text = "Log In",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.48.sp,
                    color = Color(0xFFFFFFFF)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Or Log In With", modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier.size(24.dp))
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook",
                        modifier = Modifier.size(24.dp))
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = {
                navController.navigate("signin")
            }) {
                Text(text = "Have you got an account?? click here!")
            }
        }
    }
}
