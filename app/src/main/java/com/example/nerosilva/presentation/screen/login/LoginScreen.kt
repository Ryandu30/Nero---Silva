package com.example.nerosilva.presentation.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nerosilva.R

@Composable
fun LoginScreen(modifier: Modifier, navController: NavController){
    Column(
        modifier = Modifier
            .width(412.dp)
            .height(917.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "LoginScreen",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 200.dp)
                .width(141.dp)
                .height(59.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.gunung),
                contentDescription = "Gunung",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(455.dp)
                    .height(515.dp)
            )

            Image(painter = painterResource(id = R.drawable.ellipse),
                contentDescription = "Matahari",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 50.dp, top = 26.dp)
                    .width(57.dp)
                    .height(57.dp)
            )

            Image(painter = painterResource(id = R.drawable.pohon),
                contentDescription = "Pohon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(bottom = 78.dp)
                    .width(455.dp)
                    .height(515.dp)
            )

            Image(painter = painterResource(id = R.drawable.kupu_kupu),
                contentDescription = "Kupu-kupu",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(bottom = 300.dp)
                    .width(431.dp)
                    .height(473.dp)
            )

            Button(
                modifier = Modifier
                    .padding(top = 450.dp, bottom = 0.dp)
                    .width(412.dp)
                    .height(661.dp),
                shape = RoundedCornerShape(size = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF74B49A)
                ),
                onClick = {
                    navController.navigate("signpage")
                }
            ) {

            }
        }
    }
}