package com.example.group2_oasis_finalproject

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
@Composable
fun UpdateMaritalStatusScreen() {
    var selectedStatus by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

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
        // Header
        Text(
            text = "Update Marital Status",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Information Text
        Text(
            text = "Select your marital status from the pull-down list and click Update Marital Status to submit your changes.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Dropdown Menu with Arrow Icon
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (selectedStatus.isEmpty()) "Select Marital Status" else selectedStatus,
                        modifier = Modifier.weight(1f) // Ensures the text takes up remaining space
                    )
                    Image(
                        painter = painterResource(id = R.drawable.down_arrow),
                        contentDescription = "Dropdown Arrow",
                        modifier = Modifier
                            .size(24.dp) // Adjust the size to fit proportionally
                            .padding(start = 8.dp) // Add some spacing from the text
                    )
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                val statuses = listOf(
                    "Divorced",
                    "Legally Separated",
                    "Married",
                    "Separated",
                    "Single",
                    "Unknown",
                    "Widow"
                )
                statuses.forEach { status ->
                    DropdownMenuItem(
                        text = { Text(status) },
                        onClick = {
                            selectedStatus = status
                            expanded = false
                        }
                    )
                }
            }
        }

        // Buttons for Update and Reset
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            OutlinedButton(
                onClick = { /* Handle update logic */ },
                modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Update")
            }
            OutlinedButton(
                onClick = { selectedStatus = "" }, // Reset the selection
                modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("Reset")
            }
        }

        // Footer
        Text(
            text = "Release: 8.7\n\n© 2024 Ellucian Company L.P. and its affiliates.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            color = Color.Gray
        )
    }
}

