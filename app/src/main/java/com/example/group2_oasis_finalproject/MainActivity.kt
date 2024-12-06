package com.example.group2_oasis_finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // navBar()
            // Get the ViewModel
            val viewModel: MainMenuScreenViewModel = viewModel()
            // Listen to the dark mode state
            val isDarkModeEnabled by viewModel.isDarkModeEnabled.collectAsState()

            // Apply the theme based on the state
            MaterialTheme(
                colorScheme = if (isDarkModeEnabled) darkColorScheme() else lightColorScheme()
            ) {
                // Create a NavController for navigation
                val navController = rememberNavController()
                // Show the main menu screen
                navBar(navController, viewModel)
            }
        }
    }
}