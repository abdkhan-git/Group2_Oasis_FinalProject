package com.example.group2_oasis_finalproject.RegistrationUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectATermScreen(navController: NavController) {
    val registrationScreenViewModel: RegistrationScreenViewModel =
        viewModel(navController.getBackStackEntry("RegistrationScreen"))
    val options = listOf("Fall 2024", "Spring 2025", "Summer 2025") //TODO move to db
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by rememberSaveable { mutableStateOf(options[0]) }

    // TODO Delete this temp code. I used it to load some dummy data into the DB
    // TODO make a table for semesters?
    // TODO make a table for sections
//    val course = Course("CSC", 321, 3, "Principles of Programming Languages")
//    registrationScreenViewModel.addCourse(course)


    Column(
    Modifier
    .fillMaxSize()
    .padding(16.dp),
    Arrangement.Top,
    Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            Arrangement.spacedBy(20.dp),
            Alignment.CenterHorizontally
        ) {
            Text(
                text = "It is important that before you register for classes, pay your bill or make an admissions tuition deposit you select the correct term!",
                modifier = Modifier
                    .padding(vertical = 8.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Terms flagged as *View Schedule Only* are not available for registration changes at this time.",
                modifier = Modifier
                    .padding(vertical = 8.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {expanded = !expanded}
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().menuAnchor(),
                    value = selectedOption,
                    onValueChange = {},
                    label = {Text("Select a Term")},
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
                                selectedOption = option
                                expanded = false
                            }
                        )
                    }
                }
            }
            Button(
                onClick = {
                    registrationScreenViewModel.updateTerm(selectedOption)
                    navController.navigate("RegistrationScreen")
                }
            ) {Text("Submit") }
        }

    }
}

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