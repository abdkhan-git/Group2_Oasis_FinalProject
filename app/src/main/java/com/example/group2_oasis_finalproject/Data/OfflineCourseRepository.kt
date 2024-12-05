package com.example.group2_oasis_finalproject.Data

import kotlinx.coroutines.flow.Flow

class OfflineCourseRepository(private val courseDao: CourseDao) : CourseRepository {
    override suspend fun addCourse(course: Course) {
        return courseDao.addCourse(course)
    }

    override suspend fun deleteCourse(course: Course) {
        return courseDao.deleteCourse(course)
    }

    override fun getCourseByCredits(credits: String): Flow<List<Course?>> {
        return courseDao.getCourseByCredits(credits)
    }

    override fun getCourseByTitle(partialTitle: String): Flow<List<Course?>> {
        return courseDao.getCourseByTitle(partialTitle)
    }

    override suspend fun updateCourse(course: Course) {
        return courseDao.updateCourse(course)
    }

    override fun getCourse(subject: String, number: String): Flow<Course?> {
        return courseDao.getCourse(subject, number)
    }

    override suspend fun addSection(section: Section) {
        return courseDao.addSection(section)
    }

    override suspend fun deleteSection(section: Section) {
        return courseDao.deleteSection(section)
    }

    override suspend fun updateSection(section: Section) {
        return courseDao.updateSection(section)
    }

    override suspend fun searchSections(
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
    ): List<Section> {
        return courseDao.searchSections(
            crn, courseSubject, courseNumber, section, days, time, capacity, actual, remaining, instructor, date, location, term
        )
    }

    override suspend fun getCredits(): List<String> {
        return  courseDao.getCredits()
    }

    override suspend fun getDays(): List<String> {
        return courseDao.getDays()
    }

    override suspend fun getGenEds(): List<String> {
        return courseDao.getGenEds()
    }

    override suspend fun getInstructors(): List<String> {
        return courseDao.getInstructors()
    }

    override suspend fun getModality(): List<String> {
        return courseDao.getModality()
    }

    override suspend fun getSubjects(): List<String> {
        return courseDao.getSubjects()
    }

    override suspend fun getTerms(): List<String> {
        return courseDao.getTerms()
    }

    override suspend fun getTimes(): List<String> {
        return courseDao.getTimes()
    }
}