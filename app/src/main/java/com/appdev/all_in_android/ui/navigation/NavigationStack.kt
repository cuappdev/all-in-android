package com.appdev.all_in_android.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.appdev.all_in_android.data.models.ContractRepo
import com.appdev.all_in_android.ui.components.general.AllInTopBar
import com.appdev.all_in_android.ui.screens.HomeScreen
import com.appdev.all_in_android.ui.screens.MarketplaceScreen
import com.appdev.all_in_android.ui.screens.ProfileScreen

@Composable
fun NavigationSetup() {
    val navController = rememberNavController()
    val showBottomBar = rememberSaveable { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // For screens that do not display bottom navigation bar, change below
    when (navBackStackEntry?.destination?.route) {
        else -> {
            showBottomBar.value = true
        }
    }

    Scaffold(
        topBar = { AllInTopBar(title = "Home", money = 1000) },
        bottomBar = {
            if (showBottomBar.value) {
                BottomNavigationBar(navController, NavigationItem.bottomNavTabList)
            }
        }
    ) { innerPadding ->
        SetupNavHost(
//            modifier = Modifier.padding(innerPadding),
            navController = navController,
            showBottomBar = showBottomBar
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController, tabItems: List<NavigationItem>) {
    NavigationBar(
        containerColor = Color.White,
    ) {
        val currentRoute = currentRoute(navController)
        tabItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = item.iconId
                        ),
                        contentDescription = item.route
                    )
                },
                selected = item.selectedRoutes.contains(currentRoute),
                selectedContentColor = Color.Unspecified,
                unselectedContentColor = Color.Unspecified,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}

@Composable
fun SetupNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    showBottomBar: MutableState<Boolean>,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.HOME.route
    ) {
        composable(Routes.HOME.route) {
            HomeScreen()
        }
        composable(Routes.MARKETPLACE.route) {
            MarketplaceScreen(ContractRepo.players)
        }
        composable(Routes.PROFILE.route) {
            ProfileScreen()
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}