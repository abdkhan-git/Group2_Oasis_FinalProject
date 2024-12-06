package com.example.group2_oasis_finalproject.RegistrationUI

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.Data.SectionWithSchedule
import com.example.group2_oasis_finalproject.GlobalData

@Composable
fun ScheduleScreen(navController: NavController) {
    val registrationScreenViewModel: RegistrationScreenViewModel =
        viewModel(navController.getBackStackEntry("RegistrationScreen"))
    val listSchedule by registrationScreenViewModel.getSectionsForUser(ramID = GlobalData.currentUser?.RamID
        ?: "").collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(listSchedule) { schedule ->
                ScheduleRow(
                    schedule = schedule,
                )
            }
        }
    }
}
@Composable
fun ScheduleRow(schedule: SectionWithSchedule) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text("CRN: ${schedule.crn}")
            Text("Course Number: ${schedule.number}")
            Text("Title: ${schedule.title}")
            Text("Days: ${schedule.days}")
            Text("Instructor: ${schedule.instructor}")
        }
    }
}
