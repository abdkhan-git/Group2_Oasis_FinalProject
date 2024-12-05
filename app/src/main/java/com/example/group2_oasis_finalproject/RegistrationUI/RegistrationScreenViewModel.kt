package com.example.group2_oasis_finalproject.RegistrationUI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.group2_oasis_finalproject.Data.CourseRepository
import com.example.group2_oasis_finalproject.Data.OfflineCourseRepository
import com.example.group2_oasis_finalproject.Data.Schedule
import com.example.group2_oasis_finalproject.Data.Section
import com.example.group2_oasis_finalproject.GlobalData
import com.example.group2_oasis_finalproject.MyApplication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.text.Typography.section
import kotlin.text.Typography.times

class RegistrationScreenViewModel(private val courseRepository: CourseRepository = MyApplication.CourseRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(RegistrationState())
    val uiState: StateFlow<RegistrationState> = _uiState.asStateFlow()



    val listSearchResults: StateFlow<ListSearchResults> = uiState.flatMapLatest { params ->
        courseRepository.searchSections(
            crn = params.crn,
            courseSubject = params.subject,
            courseNumber = params.course,
            section = params.instructionalMethod,
            days = params.days,
            time = params.time,
            capacity = params.credits,
            actual = null,
            remaining = null,
            instructor = params.instructor,
            date = null,
            location = null,
            term = params.term,
            credits = params.credits,
            title = params.title,
            genEd = params.attributeType
        ).map { sections ->
            Log.i("SearchResults", "Fetched sections: $sections")
            ListSearchResults(sections)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = ListSearchResults()
    )

//val listCourseNumber: StateFlow<ListDays> =
//    courseRepository.getCourseNumbers().map { cred ->
//        Log.i("RegistrationState", "Mapped terms: $cred")
//        ListDays(cred)
//    }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000L),
//            initialValue = ListDays()
//        )
//    val listTitle: StateFlow<ListDays> =
//        courseRepository.getTitles().map { cred ->
//            Log.i("RegistrationState", "Mapped terms: $cred")
//            ListDays(cred)
//        }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000L),
//                initialValue = ListDays()
//            )
//    val listCredits: StateFlow<ListDays> =
//        courseRepository.getCredits().map { cred ->
//            Log.i("RegistrationState", "Mapped terms: $cred")
//            ListDays(cred)
//        }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000L),
//                initialValue = ListDays()
//            )
//
//    val listGenEds: StateFlow<ListDays> =
//        courseRepository.getGenEds().map { gen ->
//            Log.i("RegistrationState", "Mapped terms: $gen")
//            ListDays(gen)
//        }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000L),
//                initialValue = ListDays()
//            )
//
//    val listInstructors: StateFlow<ListDays> =
//        courseRepository.getInstructors().map { inst ->
//            Log.i("RegistrationState", "Mapped terms: $inst")
//            ListDays(inst)
//        }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000L),
//                initialValue = ListDays()
//            )
//
//    val listModality: StateFlow<ListDays> =
//        courseRepository.getModality().map { modality ->
//            Log.i("RegistrationState", "Mapped terms: $modality")
//            ListDays(modality)
//        }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000L),
//                initialValue = ListDays()
//            )
//
val listSchedule: StateFlow<ListSchedule> =
    courseRepository.getUsersSchedule(GlobalData.currentUser?.RamID ?: "").map { classes ->
        Log.i("RegistrationState", "Mapped class: $classes")
        ListSchedule(classes)
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = ListSchedule()
        )

    val listSubjects: StateFlow<ListDays> =
        courseRepository.getSubjects().map { subjects ->
            Log.i("RegistrationState", "Mapped terms: $subjects")
            ListDays(subjects)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = ListDays()
            )
//
    val listTerms: StateFlow<ListDays> =
        courseRepository.getTerms().map { terms ->
            Log.i("RegistrationState", "Mapped terms: $terms")
            ListDays(terms)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = ListDays()
            )
//
//    val listTimes: StateFlow<ListDays> =
//        courseRepository.getTimes().map { times ->
//            Log.i("RegistrationState", "Mapped times: $times")
//            ListDays(times)
//        }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000L),
//                initialValue = ListDays()
//            )
//
//    val listDays: StateFlow<ListDays> =
//        courseRepository.getDays().map { days ->
//            Log.i("RegistrationState", "Mapped days: $days")
//            ListDays(days)
//        }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000L),
//            initialValue = ListDays()
//        )
//
//    fun addCourse(course: Course) {
//        viewModelScope.launch {
//            courseRepository.addCourse(course)
//        }
//    }
    fun addSection(section: Section) {
        viewModelScope.launch {
            courseRepository.addSection(section)
        }
    }
    fun addSchedule(schedule: Schedule) {
        viewModelScope.launch {
            courseRepository.addSchedule(schedule)
        }
    }
    fun deleteSchedule(schedule: Schedule) {
        viewModelScope.launch {
            courseRepository.deleteSchedule(schedule)
        }
    }
    fun getUsersSchedule(RamID: String) {
        viewModelScope.launch {
            courseRepository.getUsersSchedule(RamID)
        }
    }


    fun updateTerm(selectedTerm: String?) {
        _uiState.update { currentState ->
            currentState.copy(term = selectedTerm)
        }
        Log.i("RegistrationState", "term updated to: $selectedTerm")
    }
    fun updateSubject(selectedSubject: String?) {
        _uiState.update { currentState ->
            currentState.copy(subject = selectedSubject)
        }
        Log.i("RegistrationState", "subject updated to: $selectedSubject")
    }
    fun updateCourse(selectedCourse: String?) {
        _uiState.update { currentState ->
            currentState.copy(course = selectedCourse)
        }
        Log.i("RegistrationState", "course updated to: $selectedCourse")
    }
//    fun getCourse(): String {
//        return _uiState.value.course
//    }
    fun updateTitle(selectedTitle: String?) {
        _uiState.update { currentState ->
            currentState.copy(title = selectedTitle)
        }
        Log.i("RegistrationState", "title updated to: $selectedTitle")
    }
    fun updateInstructionalMethod(selectedInstructionalMethod: String?) {
        _uiState.update { currentState ->
            currentState.copy(instructionalMethod = selectedInstructionalMethod)
        }
        Log.i("RegistrationState", "instructionalMethod updated to: $selectedInstructionalMethod")
    }
    fun updateCredits(selectedCredits: String?) {
        _uiState.update { currentState ->
            currentState.copy(credits = selectedCredits)
        }
        Log.i("RegistrationState", "credits updated to: $selectedCredits")
    }
    fun updatePartOfTerm(selectedPartOfTerm: String?) {
        _uiState.update { currentState ->
            currentState.copy(partOfTerm = selectedPartOfTerm)
        }
        Log.i("RegistrationState", "partOfTerm updated to: $selectedPartOfTerm")
    }
    fun updateInstructor(selectedInstructor: String?) {
        _uiState.update { currentState ->
            currentState.copy(instructor = selectedInstructor)
        }
        Log.i("RegistrationState", "instructor updated to: $selectedInstructor")
    }
    fun updateAttributeType(selectedattributeType: String?) {
        _uiState.update { currentState ->
            currentState.copy(attributeType = selectedattributeType)
        }
        Log.i("RegistrationState", "attributeType updated to: $selectedattributeType")
    }
    fun updateTime(selectedTime: String?) {
        _uiState.update { currentState ->
            currentState.copy(time = selectedTime)
        }
        Log.i("RegistrationState", "updateTime updated to: $selectedTime")
    }
    fun updateDays(selectedDays: String?) {
        _uiState.update { currentState ->
            currentState.copy(days = selectedDays)
        }
        Log.i("RegistrationState", "days updated to: $selectedDays")
    }

//    fun getCredits() : List<String>  {
//        viewModelScope.launch {
//            courseRepository.getCredits()
//        }
//    }
//    fun getDays(){
//        viewModelScope.launch {
//            _days.value = courseRepository.getDays()
//            Log.i("RegistrationState", "days list contains: ${_days.value}")
//        }
//    }
//    fun getGenEds() : List<String>  {
//        viewModelScope.launch {
//            courseRepository.getGenEds()
//        }
//    }
//    fun getInstructors() : List<String>  {
//        viewModelScope.launch {
//            courseRepository.getInstructors()
//        }
//    }
//    fun getModality() : List<String>  {
//        viewModelScope.launch {
//            courseRepository.getModality()
//        }
//    }
//    fun getSubjects() : List<String>  {
//        viewModelScope.launch {
//            courseRepository.getSubjects()
//        }
//    }
//    fun getTerms() : List<String>  {
//        viewModelScope.launch {
//            courseRepository.getTerms()
//        }
//    }
//    fun getTimes() : List<String> {
//        viewModelScope.launch {
//            courseRepository.getTimes()
//        }
//    }



    init {
    }

}

data class RegistrationState(
    val crn: String? = null,
    val subject: String? = null,
    val course: String? = null,
    val instructionalMethod: String? = null,
    val title: String? = null,
    val credits: String? = null,
    val partOfTerm: String? = null,
    val instructor: String? = null,
    val attributeType: String? = null,
    val time: String? = null,
    val days: String? = null,
    val term: String? = null,

    )

data class ListDays(val listThings: List<String> = listOf())
data class ListSearchResults(val listThings: List<Section> = listOf())
data class ListSchedule(val listThings: List<Schedule> = listOf())