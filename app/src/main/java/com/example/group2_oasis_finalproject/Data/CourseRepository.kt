package com.example.group2_oasis_finalproject.Data

import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getCourse(subject: String, number: String): Flow<Course?>

    fun getCourseByCredits(credits: String): Flow<List<Course?>>

    fun getCourseByTitle(partialTitle: String): Flow<List<Course?>>

    suspend fun addCourse(course : Course)

    suspend fun updateCourse(course : Course)

    suspend fun deleteCourse(course : Course)

    suspend fun searchSections(
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
        term: String?
    ): List<Section>

    suspend fun addSection(section : Section)

    suspend fun updateSection(section : Section)

    suspend fun deleteSection(section : Section)

    suspend fun getTerms(): List<String>

    suspend fun getSubjects(): List<String>

    suspend fun getModality(): List<String>

    suspend fun getCredits(): List<String>

    suspend fun getInstructors(): List<String>

    suspend fun getGenEds(): List<String>

    suspend fun getTimes(): List<String>

    suspend fun getDays(): List<String>


}