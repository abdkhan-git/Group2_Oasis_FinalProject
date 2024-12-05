package com.example.group2_oasis_finalproject.Data

import kotlinx.coroutines.flow.Flow

interface CourseRepository {
//    fun getCourse(subject: String, number: String): Flow<Course?>
//
//    fun getCourseByCredits(credits: String): Flow<List<Course?>>
//
//    fun getCourseByTitle(partialTitle: String): Flow<List<Course?>>
//
//    suspend fun addCourse(course : Course)
//
//    suspend fun updateCourse(course : Course)
//
//    suspend fun deleteCourse(course : Course)
//
fun searchSections(
    crn: String?,
    courseSubject: String?,
    courseNumber: String?,
    section: String?,
    days: String?,
    time: String?,
    capacity: String?,
    actual: String?,
    remaining: String?,
    instructor: String?,
    date: String?,
    location: String?,
    term: String?,
    credits: String?,
    title: String?,
    genEd: String?
): Flow<List<Section>>
    //
    suspend fun addSchedule(schedule: Schedule)
    suspend fun deleteSchedule(schedule: Schedule)
    fun getUsersSchedule(RamID: String): Flow<List<Schedule>>


    suspend fun addSection(section : Section)

    suspend fun updateSection(section : Section)

    suspend fun deleteSection(section : Section)
//
    fun getTerms(): Flow<List<String>>

    fun getSubjects(): Flow<List<String>>

    fun getModality(): Flow<List<String>>

    fun getCredits(): Flow<List<String>>

    fun getInstructors(): Flow<List<String>>

    fun getGenEds(): Flow<List<String>>

    fun getTimes(): Flow<List<String>>
//
    fun getDays(): Flow<List<String>>
    fun getAllSections(): Flow<List<Section>>
    fun getTitles(): Flow<List<String>>
    fun getCourseNumbers(): Flow<List<String>>


}