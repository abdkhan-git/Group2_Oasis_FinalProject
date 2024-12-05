package com.example.group2_oasis_finalproject.Data

import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getCourse(subject: String, number: Int): Flow<Course?>

    fun getCourseByCredits(credits: Int): Flow<List<Course?>>

    fun getCourseByTitle(partialTitle: String): Flow<List<Course?>>

    suspend fun addCourse(course : Course)

    suspend fun updateCourse(course : Course)

    suspend fun deleteCourse(course : Course)
}