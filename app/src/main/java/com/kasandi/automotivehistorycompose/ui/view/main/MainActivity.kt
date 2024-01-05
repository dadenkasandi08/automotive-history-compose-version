package com.kasandi.automotivehistorycompose.ui.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kasandi.automotivehistorycompose.ui.components.BottomBar
import com.kasandi.automotivehistorycompose.ui.navigation.Screen
import com.kasandi.automotivehistorycompose.ui.theme.AutomotiveHistoryComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutomotiveHistoryComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AutomotiveHistoryComposeApp()
                }
            }
        }
    }

    @Composable
    fun AutomotiveHistoryComposeApp(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController()
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(navController)
            },
            modifier = modifier
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) {
                    HomeScreen()
                }
                composable(Screen.About.route) {
                    AboutScreen()
                }
            }
        }
    }
}