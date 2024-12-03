package com.example.group2_oasis_finalproject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen



@Composable
fun ChangePinScreen() {
    var oldPin by rememberSaveable { mutableStateOf("") }
    var newPin by rememberSaveable { mutableStateOf("") }
    var reenterNewPin by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title at the top of the screen
        Text(
            text = "Change Pin",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
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
                onClick = { /* Add functionality later */ },
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
    }
}

