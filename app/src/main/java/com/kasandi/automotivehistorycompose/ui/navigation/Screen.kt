package com.kasandi.automotivehistorycompose.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("main")
    object About : Screen("about")
}
