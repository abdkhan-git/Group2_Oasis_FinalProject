package com.example.group2_oasis_finalproject.Data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlin.text.Typography.section

class OfflineCourseRepository(private val courseDao: CourseDao) : CourseRepository {
//    override suspend fun addCourse(course: Course) {
//        return courseDao.addCourse(course)
//    }
//
//    override suspend fun deleteCourse(course: Course) {
//        return courseDao.deleteCourse(course)
//    }
//
//    override fun getCourseByCredits(credits: String): Flow<List<Course?>> {
//        return courseDao.getCourseByCredits(credits)
//    }
//
//    override fun getCourseByTitle(partialTitle: String): Flow<List<Course?>> {
//        return courseDao.getCourseByTitle(partialTitle)
//    }
//
//    override suspend fun updateCourse(course: Course) {
//        return courseDao.updateCourse(course)
//    }
//
//    override fun getCourse(subject: String, number: String): Flow<Course?> {
//        return courseDao.getCourse(subject, number)
//    }
//
    override suspend fun addSection(section: Section) {
        return courseDao.addSection(section)
    }

    override suspend fun deleteSchedule(schedule: Schedule) {
        return courseDao.deleteSchedule(schedule)
    }

    override fun getUsersSchedule(RamID: String): Flow<List<Schedule>> {
        return courseDao.getUsersSchedule(RamID)
    }



    override suspend fun addSchedule(schedule: Schedule) {
        return courseDao.addSchedule(schedule)
    }

    override suspend fun deleteSection(section: Section) {
        return courseDao.deleteSection(section)
    }

    override suspend fun updateSection(section: Section) {
        return courseDao.updateSection(section)
    }
//
override fun searchSections(
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
): Flow<List<Section>> {
        return courseDao.searchSections(
            null, courseSubject, courseNumber, section, days, time, capacity, actual, remaining, instructor, date, location, term, credits, title, genEd
        )
    }
    //
    override fun getCredits(): Flow<List<String>> {
        return  courseDao.getCredits()
    }

    override fun getDays(): Flow<List<String>> {
        val days = courseDao.getDays()
            .onEach { days ->
                Log.i("OfflineRepository", "fetched days: $days.")
            }
        Log.i("OfflineRepository", "This happened")
        return days
    }

    override fun getGenEds(): Flow<List<String>> {
        return courseDao.getGenEds()
    }

    override fun getInstructors(): Flow<List<String>> {
        return courseDao.getInstructors()
    }

    override fun getModality(): Flow<List<String>> {
        return courseDao.getModality()
    }

    override fun getSubjects(): Flow<List<String>> {
        return courseDao.getSubjects()
    }

    override fun getTerms(): Flow<List<String>> {
        return courseDao.getTerms()
    }

    override fun getTimes(): Flow<List<String>> {
        return courseDao.getTimes()
    }
    override fun getTitles(): Flow<List<String>> {
        return courseDao.getTitles()
    }
    override fun getCourseNumbers(): Flow<List<String>> {
        return courseDao.getCourseNumbers()
    }

    override fun getAllSections(): Flow<List<Section>> {
        val sections = courseDao.getAllSections().onEach {
            Log.i("OfflineRepository", "section: $it")
        }
        return sections
    }
}

