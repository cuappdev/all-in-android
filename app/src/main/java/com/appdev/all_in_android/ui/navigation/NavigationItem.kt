package com.appdev.all_in_android.ui.navigation

import com.appdev.all_in_android.R

sealed class NavigationItem(
    val route: String,
    val iconId: Int,
    val selectedRoutes: Set<String>
){
    object Home: NavigationItem(
        route = Routes.HOME.route,
        iconId = R.drawable.ic_nav_home,
        selectedRoutes = setOf(Routes.HOME.route)
    )
    object Marketplace: NavigationItem(
        route = Routes.MARKETPLACE.route,
        iconId = R.drawable.ic_nav_marketplace,
        selectedRoutes = setOf(Routes.MARKETPLACE.route)
    )
    object Profile: NavigationItem(
        route = Routes.PROFILE.route,
        iconId = R.drawable.ic_nav_profile,
        selectedRoutes = setOf(Routes.PROFILE.route)
    )

    companion object {
        val bottomNavTabList = listOf(
            Home,
            Marketplace,
            Profile
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
    HOME("home"),
    MARKETPLACE("marketplace"),
    PROFILE("profile")
}



