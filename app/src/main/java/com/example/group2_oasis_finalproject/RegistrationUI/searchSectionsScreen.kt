package com.example.group2_oasis_finalproject.RegistrationUI

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.LaunchedEffect
import com.example.group2_oasis_finalproject.Data.Section
import kotlin.text.Typography.times


@Composable
fun searchSectionsScreen(navController: NavController) {
    val registrationScreenViewModel: RegistrationScreenViewModel =
        viewModel(navController.getBackStackEntry("RegistrationScreen"))
    val registrationState by registrationScreenViewModel.uiState.collectAsState()

    //Example Data to make a schedule with
    val section = Section(
        "12345", "CSC", "321", "In Person",
        "F", "01:40 pm-02:55 pm", "24", "20", "4",
        "Matthew Fried", "01/27-05/21", "WHIT 111", "Spring 2025",
        "1", "Programming Languages", "GenEd1"
    )
    val section1 = Section(
        "94153", "BCS", "371", "Hybrid",
        "T", "01:40 pm-02:55 pm", "24", "24", "0",
        "Moaath Alrajab", "08/26-12/16", "WHIT 216", "Fall 2024",
        "3", "Android Development I", "GenEd2"
    )
    val section2 = Section(
        "91523", "EGL", "314",
        "Online", "MW", "12:15 pm-01:30 pm",
        "25", "24", "1", "Brandi D So",
        "08/26-12/16", "ON LINE", "Fall 2024",
        "2", "Literature", "GenEd3"
    )
    registrationScreenViewModel.addSection(section)
    registrationScreenViewModel.addSection(section1)
    registrationScreenViewModel.addSection(section2)


    val terms by registrationScreenViewModel.listTerms.collectAsState()
    val subjects by registrationScreenViewModel.listSubjects.collectAsState()


//    Log.i("HomeUI", "current days: ${days}")
    if (
        terms.listThings.isEmpty() or subjects.listThings.isEmpty() //or
        ) {
        Text("Loading")
    }
    else {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            Arrangement.Top,
            Alignment.CenterHorizontally
        ) {
        dropDownMenu("Term", terms.listThings, registrationScreenViewModel::updateTerm)
        dropDownMenu("Subjects", subjects.listThings, registrationScreenViewModel::updateSubject)
            Button(
                onClick = {
                    navController.navigate("SectionSearchResults")
                }
            ) { Text("Search") }
        }
    }
}