package com.example.nerosilva.presentation.nerosilvaapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nerosilva.R
import com.example.nerosilva.navigation.NavigationItem
import com.example.nerosilva.navigation.Screen
import com.example.nerosilva.presentation.screen.chatbot.ChatbotPage
import com.example.nerosilva.presentation.screen.farm.FarmPage
import com.example.nerosilva.presentation.screen.home.HomePage
import com.example.nerosilva.presentation.screen.login.component.LoginPage
import com.example.nerosilva.presentation.screen.login.component.LoginScreen
import com.example.nerosilva.presentation.screen.login.component.SigninPage
import com.example.nerosilva.presentation.screen.marketplace.MarketplacePage
import com.example.nerosilva.presentation.screen.seller.SellerPage

@Composable
fun NeroSilvaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = "loginscreen"
    ) {

        composable("loginscreen") {
            LoginScreen(modifier, navController = navController)
        }

        composable("signinpage") {
            SigninPage(modifier, navController = navController)
        }

        composable(Screen.Login.route) {
            LoginPage(modifier, navController = navController)
        }

        composable(Screen.Home.route) {
            HomePage(navController = navController)
        }

        composable(Screen.Farm.route) {
            FarmPage()
        }

        composable(Screen.Marketplace.route) {
            MarketplacePage()
        }

        composable(Screen.Chatbot.route) {
            ChatbotPage()
        }

        composable(Screen.Seller.route) {
            SellerPage()
        }
    }
}

@Composable
private fun BottomBar(
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
                title = stringResource(id = R.string.menu_marketplace),
                icon = Icons.Default.ShoppingCart,
                screen = Screen.Marketplace
            ),
            NavigationItem(
                title = stringResource(R.string.menu_chatbot),
                icon = Icons.Default.Email,
                screen = Screen.Chatbot
            ),
            NavigationItem(
                title = stringResource(R.string.menu_seller),
                icon = Icons.Default.Place,
                screen = Screen.Seller
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