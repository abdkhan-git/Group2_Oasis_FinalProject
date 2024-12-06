package com.example.group2_oasis_finalproject.RegistrationUI

import android.util.Log
import android.widget.CheckBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.Data.Schedule
import com.example.group2_oasis_finalproject.Data.Section
import com.example.group2_oasis_finalproject.GlobalData
import com.example.group2_oasis_finalproject.R
import kotlin.text.Typography.section

@Composable
fun SectionSearchResults(navController: NavController) {
    val registrationScreenViewModel: RegistrationScreenViewModel =
        viewModel(navController.getBackStackEntry("RegistrationScreen"))
    val registrationState by registrationScreenViewModel.uiState.collectAsState()
    val results by registrationScreenViewModel.listSearchResults.collectAsState()
    val currentUser = GlobalData.currentUser?.RamID

    val checkedList = remember { mutableStateOf(setOf<Section>()) }

    Log.i("SearchResults", "search params: $registrationState")
    Log.i("SearchResults", "results: ${results.listThings}")
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        Arrangement.Top,
        Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(results.listThings) { section ->
                SectionRow(
                    section = section,
                    isChecked = checkedList.value.contains(section),
                    onCheckedChange = { isChecked ->
                        checkedList.value = if (isChecked) {
                            checkedList.value + section
                        } else {
                            checkedList.value - section
                        }
                        Log.i("SearchResults", "checked: ${checkedList.value}")
                    }
                )
            }
        }
        Button(
            onClick = {
                checkedList.value.forEach() {
                    registrationScreenViewModel.addSchedule(Schedule(it.crn, currentUser.toString()))
                    navController.navigate("RegistrationScreen")
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Save Schedule")
        }
    }
}

@Composable
fun SectionRow(section: Section, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text("Subject: ${section.courseSubject}")
            Text("Course Number: ${section.courseNumber}")
            Text("Title: ${section.title}")
            Text("Days: ${section.days}")
            Text("Capacity: ${section.capacity}")
            Text("Actual: ${section.actual}")
            Text("Remaining: ${section.remaining}")
            Text("Instructor: ${section.instructor}")
        }
    }
}
