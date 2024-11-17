package com.example.group2_oasis_finalproject

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * Main menu screen displaying various options for students,
 * such as registration, bill payment, student records, personal info, etc.
 *
 * @param navController Used to navigate to other screens in the application
 */
@Composable
fun mainmenuscreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Enable vertical scrolling for the menu
    ) {
        // Graduation Candidates Section
        Text(
            text = "CANDIDATES FOR GRADUATION",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Description for graduation candidates
        Text(
            text = "Students intending to graduate in Fall 2024 or Winter 2025 should review the following lists:",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Fall 2024 Graduation List (Clickable)
        Text(
            text = "Candidates for Graduation - Fall 2024 list",
            style = TextStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier
                .clickable { /* Handle click for navigation or action */ }
                .padding(bottom = 4.dp)
        )

        // Winter 2025 Graduation List (Clickable)
        Text(
            text = "Candidates for Graduation - Winter 2025 list",
            style = TextStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier
                .clickable { /* Handle click for navigation or action */ }
                .padding(bottom = 16.dp)
        )

        // Registration menu option with a brief description and navigation on click
        MenuSection(
            title = "Registration",
            description = "Check your registration status; Add or Drop Classes; Display your class schedule",
            onClick = { navController.navigate("RegistrationScreen") }
        )

        // Bill payment menu option; navigation not included
        MenuSection(
            title = "Pay Your Bill",
            description = "Access the Student Account Payment/Billing Center, to view your bill and pay online using MasterCard, Visa, Discover or Amex.\nNOTE: Admissions applicants should NOT use this link to pay their advance tuition deposit",
            onClick = { /* Handle click for action */ }
        )

        // Student records section with navigation
        MenuSection(
            title = "Student Records",
            description = "Order official transcripts online; Display your grades and transcript; View your holds (restrictions); Review charges and payments; View general student record information and Ram ID",
            onClick = { navController.navigate("StudentRecordsScreen") }
        )

        // Personal information section with navigation
        MenuSection(
            title = "Personal Information",
            description = "View your address(es) and phone number(s), Update your emergency contact information, marital status; Change your OASIS Login PIN and Security Question; Register your personal contact information with NY-ALERT to receive E-Mail, Voice and Text Messaging Alerts during Campus Emergencies",
            onClick = { navController.navigate("PersonalInformationScreen") }
        )

        // Financial aid information with navigation
        MenuSection(
            title = "Financial Aid",
            description = "Review the status of your financial aid application; Check the status of your document requirements; Review your loans",
            onClick = { navController.navigate("FinancialInformationScreen") }
        )

        // Parking and traffic violation management, with placeholder for navigation
        MenuSection(
            title = "Parking Decals & Traffic Violations",
            description = "Purchase campus parking decals, pay parking citations and/or request a traffic citation hearing",
            onClick = { /* Handle click for action */ }
        )
    }
}

/**
 * MenuSection composable function to display individual menu options as clickable cards.
 *
 * @param title The title of the menu section
 * @param description A brief description of what the section contains or allows the user to do
 * @param onClick A lambda function executed when the section is clicked, typically for navigation
 */
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
            .clickable(onClick = onClick), // Handle card click for navigation or action
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Set card elevation for shadow effect
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp) // Padding inside the card for spacing
        ) {
            // Display the title of the section in bold with a distinct color
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4B0082)  // Dark Purple color
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Description text for the menu option
            Text(
                text = description,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}
