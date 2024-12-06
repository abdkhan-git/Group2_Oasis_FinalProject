package com.example.group2_oasis_finalproject.RegistrationUI

import android.util.Log
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.Data.Schedule
import com.example.group2_oasis_finalproject.Data.Section
import com.example.group2_oasis_finalproject.GlobalData
import kotlin.text.Typography.section

@Composable
fun dropClassesScreen(navController: NavController) {
    val registrationScreenViewModel: RegistrationScreenViewModel =
        viewModel(navController.getBackStackEntry("RegistrationScreen"))
    val registrationState by registrationScreenViewModel.uiState.collectAsState()
    val listSchedule by registrationScreenViewModel.listSchedule.collectAsState()
    val currentUser = GlobalData.currentUser?.RamID

    val checkedList = remember { mutableStateOf(setOf<Schedule>()) }

//    Log.i("SearchResults", "search params: $registrationState")
//    Log.i("SearchResults", "results: ${listSchedule.listThings}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(listSchedule.listThings) { schedule ->
                dropScheduleRow(
                    schedule = schedule,
                    isChecked = checkedList.value.contains(schedule),
                    onCheckedChange = { isChecked ->
                        checkedList.value = if (isChecked) {
                            checkedList.value + schedule
                        } else {
                            checkedList.value - schedule
                        }
                        Log.i("SearchResults", "checked: ${checkedList.value}")
                    }
                )
            }
        }
        Button(
            onClick = {
                checkedList.value.forEach { schedule ->
                    registrationScreenViewModel.deleteSchedule(schedule)
                }
                navController.navigate("RegistrationScreen")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Drop Classes")
        }
    }
}

@Composable
fun dropScheduleRow(schedule: Schedule, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
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
            Text("CRN: ${schedule.crn}")
            Text("RamID: ${schedule.RamID}")
        }
    }
}
