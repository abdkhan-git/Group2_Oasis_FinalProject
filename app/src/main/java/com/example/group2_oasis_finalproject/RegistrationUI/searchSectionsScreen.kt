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

    //preemptive insert code for this example
    // The live version of this app would be plugged into banner and pull data from there
//    val course = Course("CSC", "321", "2", "Principles of Programming Languages")
//    val course1 = Course("BCS", "371", "3", "Mobile Application Development I")
//    val course2 = Course("EGL", "314", "4", "Major Authors in World Literature")
//    registrationScreenViewModel.addCourse(Course("EGL", "315", "4", " Literature"))
//    registrationScreenViewModel.addCourse(course)
//    registrationScreenViewModel.addCourse(course1)
//    registrationScreenViewModel.addCourse(course2)
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
//    val modalities by registrationScreenViewModel.listModality.collectAsState()
//    val credits by registrationScreenViewModel.listCredits.collectAsState()
//    val instructors by registrationScreenViewModel.listInstructors.collectAsState()
//    val genEds by registrationScreenViewModel.listGenEds.collectAsState()
//    val times by registrationScreenViewModel.listTimes.collectAsState()
//    val days by registrationScreenViewModel.listDays.collectAsState()
//    val courseNumber by registrationScreenViewModel.listCourseNumber.collectAsState()
//    val title by registrationScreenViewModel.listTitle.collectAsState()


//    Log.i("HomeUI", "current days: ${days}")
    if (
//        days.listThings.isEmpty() or times.listThings.isEmpty() or
        terms.listThings.isEmpty() or subjects.listThings.isEmpty() //or
//        modalities.listThings.isEmpty() or credits.listThings.isEmpty() or
//        instructors.listThings.isEmpty() or genEds.listThings.isEmpty() or
//        courseNumber.listThings.isEmpty() or title.listThings.isEmpty()
        ) {
        Text("Loading")
    }
    else {
//        registrationScreenViewModel.updateDays(days.listThings[0])
//        registrationScreenViewModel.updateTime(times.listThings[0])
//        registrationScreenViewModel.updateTerm(terms.listThings[0])
//        registrationScreenViewModel.updateSubject(subjects.listThings[0])
//        registrationScreenViewModel.updateInstructionalMethod(modalities.listThings[0])
//        registrationScreenViewModel.updateCredits(credits.listThings[0])
//        registrationScreenViewModel.updateInstructor(instructors.listThings[0])
//        registrationScreenViewModel.updateAttributeType(genEds.listThings[0])
//        registrationScreenViewModel.updateTitle(instructors.listThings[0])
//        registrationScreenViewModel.updateCourse(genEds.listThings[0])

//        registrationScreenViewModel.updateDays(null)
//        registrationScreenViewModel.updateTime(null)
//        registrationScreenViewModel.updateTerm(null)
//        registrationScreenViewModel.updateSubject(null)
//        registrationScreenViewModel.updateInstructionalMethod(null)
//        registrationScreenViewModel.updateCredits(null)
//        registrationScreenViewModel.updateInstructor(null)
//        registrationScreenViewModel.updateAttributeType(null)
//        registrationScreenViewModel.updateTitle(null)
//        registrationScreenViewModel.updateCourse(null)
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            Arrangement.Top,
            Alignment.CenterHorizontally
        ) {
        dropDownMenu("Term", terms.listThings, registrationScreenViewModel::updateTerm)
        dropDownMenu("Subjects", subjects.listThings, registrationScreenViewModel::updateSubject)
//            dropDownMenu("Course Number", courseNumber.listThings, registrationScreenViewModel::updateCourse)
//            dropDownMenu("Title", title.listThings, registrationScreenViewModel::updateTitle)

//            OutlinedTextField(
//                value = "Course",
//                onValueChange = { newValue ->
//                    registrationScreenViewModel.updateCourse(newValue)
//                },
//                label = { Text(text = "Course Number") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            OutlinedTextField(
//                value = "Title",
//                onValueChange = { newValue ->
//                    registrationScreenViewModel.updateTitle(newValue)
//                },
//                label = { Text(text = "Title") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        dropDownMenu("Instructional Methods", modalities.listThings, registrationScreenViewModel::updateInstructionalMethod)
//        dropDownMenu("Credits",credits.listThings, registrationScreenViewModel::updateCredits)
//        dropDownMenu("Instructors",instructors.listThings, registrationScreenViewModel::updateInstructor)
//        dropDownMenu("Attribute Types",genEds.listThings, registrationScreenViewModel::updateAttributeType)
//        dropDownMenu("Times",times.listThings, registrationScreenViewModel::updateTime)
//            dropDownMenu("Days", days.listThings, registrationScreenViewModel::updateDays)
            Button(
                onClick = {
                    navController.navigate("SectionSearchResults")
                }
            ) { Text("Search") }
        }
    }
}