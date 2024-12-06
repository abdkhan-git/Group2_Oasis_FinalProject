package com.example.group2_oasis_finalproject.RegistrationUI

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropDownMenu(
    label: String,
    options: List<String>,
    onOptionSelected: (selectedOption: String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by rememberSaveable { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {expanded = !expanded}
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().menuAnchor(),
            value = selectedOption,
            onValueChange = {},
            label = {Text(label)},
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
            readOnly = true
        )
        ExposedDropdownMenu(
            expanded= expanded,
            onDismissRequest = {expanded = false}
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {Text(option)},
                    onClick = {
                        onOptionSelected(option)
                        selectedOption = option
                        expanded = false
                    }
                )
            }

}}}