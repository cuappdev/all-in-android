package com.appdev.all_in_android.ui.navigation

import com.appdev.all_in_android.R

sealed class NavigationItem(
    val route: String,
    val iconId: Int,
    val selectedRoutes: Set<String>
){
    object Home: NavigationItem(
        route = Routes.HOME.route,
        iconId = R.drawable.ic_home,
        selectedRoutes = setOf(Routes.HOME.route)
    )
    object Marketplace: NavigationItem(
        route = Routes.MARKETPLACE.route,
        iconId = R.drawable.ic_marketplace,
        selectedRoutes = setOf(Routes.MARKETPLACE.route)
    )
    object BetTracker: NavigationItem(
        route = Routes.BET_TRACKER.route,
        iconId = R.drawable.ic_bet_tracker,
        selectedRoutes = setOf(Routes.BET_TRACKER.route)
    )

    companion object {
        val bottomNavTabList = listOf(
            Home,
            Marketplace,
            BetTracker
        )
    }
}

/**
 * All NavUnit must have a route (which specifies where to
 * navigate to).
 */
interface NavUnit {
    val route: String
}

/**
 * Contains information about all known routes. These should correspond to routes in our
 * NavHost/new routes should be added here. Routes can exist independent of tabs (like onboarding).
 */
enum class Routes(override var route: String) : NavUnit {
    HOME("Home"),
    HOME_FAQ("Home FAQ"),
    MARKETPLACE("Marketplace"),
    MARKETPLACE_FAQ("Marketplace FAQ"),
    CART("Cart"),
    BET_TRACKER("Bet Tracker"),
    BET_TRACKER_FAQ("Bet Tracker FAQ"),
    SELL_CONTRACT("Sell Contract"),
    SELL_SELECTED_CONTRACT("Sell Selected Contract"),
    SELL_CONTRACT_CONFIRMATION("Sell Contract Confirmation"),
    CONTRACT_SUCCESS("Contract Success"),
    BUY_CONTRACT("Buy Contract"),
    BUY_CONTRACT_SUCCESS("Buy Success"),
    ENDING_TODAY("Ending Today")
}



