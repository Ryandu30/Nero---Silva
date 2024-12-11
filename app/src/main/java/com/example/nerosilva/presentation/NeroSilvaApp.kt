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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.example.nerosilva.presentation.screen.notification.NotificationPage
import com.example.nerosilva.presentation.screen.profile.ProfilePage

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
                            Spacer(modifier = Modifier.width(12.dp))
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Nero Silva Icon",
                                modifier = Modifier
                                    .size(95.dp)
                                    .padding(end = 8.dp)
                            )
                        }
                    },
                    actions = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = { navController.navigate(Screen.Notification.route) }) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "Notification",
                                    modifier = Modifier.size(35.dp)
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
                LoginScreen(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Register.route) {
                RegisterPage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Login.route) {
                LoginPage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Home.route) {
                HomePage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Notification.route) {
                NotificationPage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Farm.route) {
                FarmPage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Calender.route) {
                CalendarPage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Chatbot.route) {
                ChatbotPage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Profile.route) {
                ProfilePage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.Account.route) {
                AccountInfoPage(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(Screen.SecurityAndPrivacy.route) {
                SecurityAndPrivacyPage(
                    modifier = modifier,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun AccountInfoPage(modifier: Modifier, navController: NavHostController) {

}

@Composable
fun SecurityAndPrivacyPage(modifier: Modifier, navController: NavHostController) {

}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color(0xFF5C8D89)
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
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.Person,
                screen = Screen.Profile
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
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = Color.White
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFF74B49B),
                )
            )
        }
    }
}