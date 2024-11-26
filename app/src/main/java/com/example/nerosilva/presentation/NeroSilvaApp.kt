package com.example.nerosilva.presentation.nerosilvaapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nerosilva.R
import com.example.nerosilva.utils.shouldShowBottomBar
import com.example.nerosilva.navigation.NavigationItem
import com.example.nerosilva.navigation.Screen
import com.example.nerosilva.presentation.screen.chatbot.ChatbotPage
import com.example.nerosilva.presentation.screen.farm.FarmPage
import com.example.nerosilva.presentation.screen.farm.component.CalendarPage
import com.example.nerosilva.presentation.screen.home.HomePage
import com.example.nerosilva.presentation.screen.login.component.LoginPage
import com.example.nerosilva.presentation.screen.login.LoginScreen
import com.example.nerosilva.presentation.screen.login.component.RegisterPage

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeroSilvaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    Scaffold(
        topBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar(),
            ) {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = "Back",
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Nero Silva Icon",
                                modifier = Modifier
                                    .width(75.dp)
                                    .height(40.dp)
                                    .padding(end = 8.dp)
                            )
                        }
                    },
                    actions = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = { }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.image),
                                    contentDescription = "Notification",
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "User",
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                        }
                    }
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = "loginscreen",
            modifier = modifier.padding(contentPadding)
        ) {

        composable("loginscreen") {
            LoginScreen(modifier = modifier, navController = navController)
        }

        composable(Screen.Register.route) {
            RegisterPage(modifier = modifier, navController = navController)
        }

        composable(Screen.Login.route) {
            LoginPage(modifier, navController = navController)
        }

        composable(Screen.Home.route) {
            HomePage(modifier, navController = navController)
        }

        composable(Screen.Farm.route) {
            FarmPage(modifier, navController = navController)
        }
            composable(Screen.Calender.route) {
                CalendarPage(modifier, navController = navController)
            }

            composable(Screen.Chatbot.route) {
                ChatbotPage(modifier, navController = navController)
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_farm),
                icon = Icons.Default.DateRange,
                screen = Screen.Farm
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_chatbot),
                icon = Icons.Default.Face,
                screen = Screen.Chatbot
            )
        )

        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
                )
            }
        }
    }