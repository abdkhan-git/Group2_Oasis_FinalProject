package com.example.group2_oasis_finalproject.RegistrationUI

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.group2_oasis_finalproject.Data.Course
import com.example.group2_oasis_finalproject.Data.CourseRepository
import com.example.group2_oasis_finalproject.Data.OfflineCourseRepository
import com.example.group2_oasis_finalproject.MyApplication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationScreenViewModel(private val courseRepository: CourseRepository = MyApplication.CourseRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(RegistrationState())
    val uiState: StateFlow<RegistrationState> = _uiState.asStateFlow()

    fun addCourse(course: Course) {
        viewModelScope.launch {
            courseRepository.addCourse(course)
        }
    }

    fun updateTerm(selectedTerm: String) {
        _uiState.update { currentState ->
            currentState.copy(term = selectedTerm)
        }
        Log.i("RegistrationState", "state updated to: $selectedTerm")
    }
}

data class RegistrationState(
    val term: String = ""
)