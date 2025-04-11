package com.appdev.all_in_android.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.appdev.all_in_android.data.models.ContractRepo.players
import com.appdev.all_in_android.data.repositories.marketplaceFAQ
import com.appdev.all_in_android.ui.screens.BetTrackerFAQScreen
import com.appdev.all_in_android.ui.screens.BetTrackerScreen
import com.appdev.all_in_android.ui.screens.CartScreen
import com.appdev.all_in_android.ui.screens.ContractSuccessScreen
import com.appdev.all_in_android.ui.screens.HomeScreen
import com.appdev.all_in_android.ui.screens.MarketplaceFAQScreen
import com.appdev.all_in_android.ui.screens.MarketplaceScreen
import com.appdev.all_in_android.ui.screens.SellContractScreen
import com.appdev.all_in_android.ui.screens.SellSelectedContractScreen
import com.appdev.all_in_android.util.myFavoriteContract
import kotlin.time.Duration.Companion.days

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
        bottomBar = {
            if (showBottomBar.value) {
                BottomNavigationBar(navController, NavigationItem.bottomNavTabList)
            }
        },
        containerColor = Color(0xFF15141B)
    ) { innerPadding ->
        Box(
            Modifier.padding(innerPadding)
        ){
            SetupNavHost(
                navController = navController,
                showBottomBar = showBottomBar
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController, tabItems: List<NavigationItem>) {
    NavigationBar(
        containerColor = Color(0xFF15141B)
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
                label = {
                    Text(
                        text = item.route,
                        fontSize = 12.sp,
                        color = Color.White
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
            HomeScreen(
                toCart = {navController.navigate("Cart")}
            )
        }
        composable(Routes.MARKETPLACE.route) {
            MarketplaceScreen(
                currentAmount = 1000.0,
                recommendedContracts = List(3) {
                    myFavoriteContract
                },
                contractsEndingToday = List(3) {
                    myFavoriteContract
                },
                allContracts = List(10) { myFavoriteContract },
                navController = navController
            )
        }
        composable(Routes.MARKETPLACE_FAQ.route){
            MarketplaceFAQScreen(navBack = { navController.popBackStack() })
        }
        composable(Routes.BET_TRACKER.route) {
            BetTrackerScreen(
                currentAmount = 1000.0,
                totalProfit = 64.0,
                ranking = 52,
                contractsSold = 7 ,
                ageOfAccount =  17.days,
                recommendedContracts = players,
                activeBets = players,
                pastBets = players,
                navController = navController
            )
        }
        composable(Routes.CART.route){
            CartScreen(wealth = 1000, homeContracts = players, marketplaceContracts = players, {navController.popBackStack()})
        }
        composable(Routes.BET_TRACKER_FAQ.route){
            BetTrackerFAQScreen(navBack = { navController.popBackStack() })
        }


        composable(Routes.SELL_CONTRACT.route){
            SellContractScreen(
                onBackClick = {navController.popBackStack()},
                toSellSelected = {navController.navigate("Sell Selected Contract")}
            )
        }
        composable(Routes.SELL_SELECTED_CONTRACT.route){
            SellSelectedContractScreen(
                onBackClick = {navController.popBackStack()},
                onConfirmClick = {navController.navigate("Sell Contract Confirmation")}
            )
        }
        composable(Routes.SELL_CONTRACT_CONFIRMATION.route){
            SellSelectedContractScreen(
                onBackClick = {navController.popBackStack()},
                onConfirmClick = {navController.navigate("Contract Success")}
            )
        }
        composable(Routes.CONTRACT_SUCCESS.route){
            ContractSuccessScreen(
                onReturnClick = {navController.navigate("Marketplace")}
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}