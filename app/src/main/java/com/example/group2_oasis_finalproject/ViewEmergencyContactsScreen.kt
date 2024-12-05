package com.example.group2_oasis_finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Data class for structured emergency contact information
//data class EmergencyContact(
//    val name: String,
//    val address: String,
//    val phone: String,
//    val relationship: String
//)

@Composable
fun ViewEmergencyContactsScreen(
    emergencyContacts: List<EmergencyContact>,
    navController: NavHostController // Pass NavController for navigation
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // Image
        Image(
            painter = painterResource(id = R.drawable.fsclogorgb),
            contentDescription = "Transparent Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Emergency Contacts Header
        Text(
            text = if (emergencyContacts.isNotEmpty()) {
                "View Emergency Contacts"
            } else {
                "Caution: No Emergency Contact Information found."
            },
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Display Contacts or No Contacts Message
        if (emergencyContacts.isNotEmpty()) {
            Column {
                emergencyContacts.forEach { contact ->
                    Text(
                        text = "Name: ${contact.name}\n" +
                                "Address: ${contact.address}\n" +
                                "Phone: ${contact.phone}\n" +
                                "Relationship: ${contact.relationship}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        } else {
            Text(
                text = "No emergency contacts listed.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        // Update Emergency Contacts Button
        OutlinedButton(
            onClick = { navController.navigate("UpdateEmergencyContactsScreen") }, // Navigate to Update Contacts screen
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Update Emergency Contacts")
        }

        // Footer with Release Information
        Spacer(modifier = Modifier.weight(1f)) // Push footer to the bottom
        Text(
            text = "Release: 8.7\n\n© 2024 Ellucian Company L.P. and its affiliates.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

