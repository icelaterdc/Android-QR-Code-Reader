package com.example.qrcodeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qrcodeapp.ui.ScanScreen
import com.example.qrcodeapp.ui.GenerateScreen
import com.example.qrcodeapp.ui.HistoryScreen
import com.example.qrcodeapp.ui.FavoritesScreen
import com.example.qrcodeapp.ui.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "scan") {
        composable("scan") { ScanScreen(navController) }
        composable("generate") { GenerateScreen(navController) }
        composable("history") { HistoryScreen(navController) }
        composable("favorites") { FavoritesScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
    }
}
