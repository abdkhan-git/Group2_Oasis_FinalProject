// mainmenuscreen.kt
package com.example.group2_oasis_finalproject

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun mainmenuscreen(navController: NavController, viewModel: MainMenuScreenViewModel) {
    val context = LocalContext.current
    val currentUser by viewModel.currentUser.collectAsState()
    val isDarkModeEnabled by viewModel.isDarkModeEnabled.collectAsState()
    val currentTime = remember {
        SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a", Locale.US).format(Date())
    }

    // Wrap the entire screen with MaterialTheme
    MaterialTheme(
        colorScheme = if (isDarkModeEnabled) darkColorScheme() else lightColorScheme()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Toggle for Dark Mode
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Enable Dark Mode",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Switch(
                        checked = isDarkModeEnabled,
                        onCheckedChange = { viewModel.toggleTheme() } ,
                    )
                }
            }

            }

            // Graduation Section
            item {
                Column(modifier = Modifier.padding(vertical = 16.dp)) {
                    Text(
                        text = "CANDIDATES FOR GRADUATION",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Students intending to graduate in Fall 2024 or Winter 2025 should review the following lists:",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Text(
                        text = "Candidates for Graduation - Fall 2024 list",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .clickable { /* Handle click */ }
                            .padding(vertical = 4.dp)
                    )
                    Text(
                        text = "Candidates for Graduation - Winter 2025 list",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .clickable { /* Handle click */ }
                            .padding(vertical = 4.dp)
                    )
                }
            }

            // Main Menu Items
            item {
                MenuSection(
                    title = "Registration",
                    description = "Check your registration status; Add or Drop Classes; Display your class schedule",
                    onClick = { navController.navigate("RegistrationScreen") }
                )
            }

            item {
                MenuSection(
                    title = "Pay Your Bill",
                    description = "Access the Student Account Payment/Billing Center, to view your bill and pay online using MasterCard, Visa, Discover or Amex.",
                    onClick = {
                        val webpage = Uri.parse("https://epay.farmingdale.edu/C21458_tsa/web/login.jsp")
                        val intent = Intent(Intent.ACTION_VIEW, webpage)
                        context.startActivity(intent)
                    }
                )
            }

            item {
                MenuSection(
                    title = "Student Records",
                    description = "Order official transcripts online; Display your grades and transcript; View your holds",
                    onClick = { navController.navigate("StudentRecordsScreen") }
                )
            }

            item {
                MenuSection(
                    title = "Personal Information",
                    description = "View your address(es) and phone number(s); Update your emergency contact information",
                    onClick = { navController.navigate("PersonalInformationScreen") }
                )
            }

            item {
                MenuSection(
                    title = "Financial Aid",
                    description = "Review the status of your financial aid application; Check document requirements",
                    onClick = { navController.navigate("FinancialInformationScreen") }
                )
            }

            item {
                MenuSection(
                    title = "Parking Decals & Traffic Violations",
                    description = "Purchase campus parking decals, pay parking citations",
                    onClick = { /* Handle click */ }
                )
            }
        }
    }
}


@Composable
private fun MenuSection(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
