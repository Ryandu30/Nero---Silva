package com.example.nerosilva.presentation.screen.home

import androidx.annotation.Nullable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.nerosilva.R
import com.example.nerosilva.ui.theme.NeroSilvaTheme

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavHostController? = null) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
            .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                tint = Color.Unspecified,
                modifier =  modifier
                .width(73.45736.dp)
                .height(31.93798.dp)
            )

            Row {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.weather),
                contentDescription = "Weather",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "28°C", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "Jambi Selatan, 23 Sep", fontSize = 14.sp)
            }
        }

    Spacer(modifier = modifier.height(16.dp))

    Card(
        modifier = Modifier
            .width(349.dp)
            .height(256.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 20.dp))

    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Hallo Bagaimana kabarmu hari ini Arman?",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF5C8D89),
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Siap untuk Memulai berkebun hari ini?",
                style = TextStyle(
                    fontSize = 20.sp,

                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { }, modifier = modifier
                    .padding(start = 113.dp, top = 23.dp)
                    .width(154.01981.dp)
                    .height(34.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF5C8D89))
            ) {
                Text(
                    text = "Mulai Berkebun",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                }
            }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Rekomendasi Edukasi", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .width(163.dp)
                    .height(252.dp)
                    .weight(1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.hidroponik_1),
                        contentDescription = "Edukasi 1",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(141.dp)
                            .height(147.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Hidroponik Milenial", modifier = Modifier.padding(8.dp))
                }
            }
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .width(163.dp)
                    .height(252.dp)
                    .weight(1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.hidroponik_2),
                        contentDescription = "Edukasi 2",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(141.dp)
                            .height(147.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Hidroponik Mudah", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    NeroSilvaTheme {
        HomePage()
    }
}