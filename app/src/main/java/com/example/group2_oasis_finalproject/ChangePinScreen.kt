package com.example.group2_oasis_finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen

@Composable
fun ChangePinScreen(navController: NavController) {
    var oldPin by rememberSaveable { mutableStateOf("") }
    var newPin by rememberSaveable { mutableStateOf("") }
    var reenterNewPin by rememberSaveable { mutableStateOf("") }

    // Wrap the entire content in a scrollable column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())  // Make the content scrollable
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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

        // Row to align "Change Pin" text to the right
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start // Align text to the right
        ) {
            Text(
                text = "Change Pin",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        // Information Text
        Text(
            text = "Please enter your old PIN and then pick a new PIN.\n" +
                    "Re-enter your new PIN for verification.\n\n" +
                    "Your new PIN must be six (6) characters long and be composed of numbers only.",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 24.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        // Old Pin field
        OutlinedTextField(
            value = oldPin,
            onValueChange = { oldPin = it },
            label = { Text(text = "Enter Old Pin") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // New Pin field
        OutlinedTextField(
            value = newPin,
            onValueChange = { newPin = it },
            label = { Text(text = "Enter New Pin") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Re-enter New Pin field
        OutlinedTextField(
            value = reenterNewPin,
            onValueChange = { reenterNewPin = it },
            label = { Text(text = "Re-enter New Pin") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Buttons at the bottom of the screen
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Change Pin Button
            Button(
                onClick = { navController.navigate("PersonalInformationScreen") },
                colors = ButtonDefaults.buttonColors(containerColor = FarmingdaleGreen)
            ) {
                Text(text = "Change Pin", color = Color.White)
            }

            // Reset Button
            OutlinedButton(
                onClick = { /* Add reset functionality later */ },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = FarmingdaleGreen)
            ) {
                Text(text = "Reset")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Footer with updated version info
        Text(
            text = "Release: 8.10.1.E\n© 2024 Ellucian Company L.P. and its affiliates.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 17.dp)
        )
    }
}
