package com.example.novowest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.novowest.model.BottomNavItem
import com.example.novowest.ui.theme.*
import com.example.novowest.R

@Composable
fun MainScreen(
) {
    val title = remember{ mutableStateOf("Главная")}
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar(title) },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = stringResource(id = R.string.home),
                        route = ContentScreen.Home.name,
                        icon = Icons.Outlined.Home
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.cart),
                        route = ContentScreen.Cart.name,
                        icon = Icons.Outlined.ShoppingCart,
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.profile),
                        route = ContentScreen.Profile.name,
                        icon = Icons.Outlined.Person,
                    ),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                    title.value=it.name
                }
            )
        }
    )
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
        {
            BottomBarNavigation(navController = navController)
        }
    }
}


@Composable
fun BottomNavigationBar(
    darkTheme: Boolean = isSystemInDarkTheme(),
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier,
        elevation = 6.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = if (darkTheme) White else Indigo600,
                unselectedContentColor = if (darkTheme) Color.Gray else Dark,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                        Text(
                            text = item.name,
                            fontSize = 10.sp,
                            fontFamily = Montserrat
                        )
                    }
                }
            )
        }
    }
}


@Composable
fun TopBar(title: MutableState<String>){
    TopAppBar() {
        Text(text = title.value,
            fontSize = 24.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold)
    }
}


