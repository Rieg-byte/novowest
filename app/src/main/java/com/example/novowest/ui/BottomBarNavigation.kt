package com.example.novowest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.novowest.ui.CartScreen
import com.example.novowest.ui.HomeScreen
import com.example.novowest.ui.ProfileScreen
import com.example.novowest.ui.SignInScreen


enum class ContentScreen() {
    Home,
    Cart,
    Profile
}


@Composable
fun BottomBarNavigation(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = ContentScreen.Home.name
    ){
        composable(route = ContentScreen.Home.name) {
            HomeScreen()
        }
        composable(route = ContentScreen.Cart.name) {
            CartScreen()
        }
        composable(route = ContentScreen.Profile.name) {
            ProfileScreen()
        }
    }
}