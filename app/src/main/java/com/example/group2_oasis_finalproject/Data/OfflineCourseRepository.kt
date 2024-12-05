package com.example.group2_oasis_finalproject.Data

import kotlinx.coroutines.flow.Flow

class OfflineCourseRepository(private val courseDao: CourseDao) : CourseRepository {
    override suspend fun addCourse(course: Course) {
        return courseDao.addCourse(course)
    }

    override suspend fun deleteCourse(course: Course) {
        return courseDao.deleteCourse(course)
    }

    override fun getCourseByCredits(credits: Int): Flow<List<Course?>> {
        return courseDao.getCourseByCredits(credits)
    }

    override fun getCourseByTitle(partialTitle: String): Flow<List<Course?>> {
        return courseDao.getCourseByTitle(partialTitle)
    }

    override suspend fun updateCourse(course: Course) {
        return courseDao.updateCourse(course)
    }

    override fun getCourse(subject: String, number: Int): Flow<Course?> {
        return courseDao.getCourse(subject, number)
    }
}