package com.example.novowest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.novowest.ui.MainScreen
import com.example.novowest.ui.SignInScreen
import com.example.novowest.ui.SignUpScreen

enum class AuthScreen() {
    SignIn,
    SignUp,
    Main
}


@Composable
fun Navigation(
    navController: NavHostController =  rememberNavController(),
){
    NavHost(
        navController = navController,
        startDestination = AuthScreen.SignIn.name
    ) {
        composable(route = AuthScreen.SignIn.name) {
            SignInScreen(navController = navController)
        }
        composable(route = AuthScreen.SignUp.name) {
            SignUpScreen(navController = navController)
        }
        composable(route = AuthScreen.Main.name) {
            MainScreen()
        }
    }
}
