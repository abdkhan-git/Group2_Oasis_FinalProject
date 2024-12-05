package com.example.group2_oasis_finalproject.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Update
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
//    @Query("SELECT * FROM Course WHERE subject = :subject AND number = :number")
//    fun getCourse(subject: String, number: String): Flow<Course?>
//
//    @Query("SELECT * FROM Course WHERE credits = :credits")
//    fun getCourseByCredits(credits: String): Flow<List<Course?>>
//
//    @Query("SELECT * FROM Course WHERE title LIKE :partialTitle || '%'")
//    fun getCourseByTitle(partialTitle: String): Flow<List<Course?>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addCourse(course : Course)
//
//    @Update
//    suspend fun updateCourse(course : Course)
//
//    @Delete
//    suspend fun deleteCourse(course : Course)
//
@Query("""
    SELECT * FROM Section
    WHERE (:crn IS NULL OR crn = :crn)
      AND (:courseSubject IS NULL OR subject = :courseSubject)
      AND (:courseNumber IS NULL OR number = :courseNumber)
      AND (:section IS NULL OR section = :section)
      AND (:days IS NULL OR days = :days)
      AND (:time IS NULL OR time =:time)
      AND (:capacity IS NULL OR capacity = :capacity)
      AND (:actual IS NULL OR actual = :actual)
      AND (:remaining IS NULL OR remaining = :remaining)
      AND (:instructor IS NULL OR instructor = :instructor)
      AND (:date IS NULL OR date = :date)
      AND (:location IS NULL OR location = :location)
      AND (:term IS NULL OR term = :term)
      AND (:credits IS NULL OR credits = :credits)
      AND (:title IS NULL OR title = :title)
      AND (:genEd IS NULL OR genEd = :genEd)
""")
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSchedule(schedule: Schedule)
    @Delete
    suspend fun deleteSchedule(schedule: Schedule)

    @Query("SELECT * FROM Schedule WHERE (RamID = :RamID)")
    fun getUsersSchedule(RamID: String): Flow<List<Schedule>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSection(section : Section)

    @Update
    suspend fun updateSection(section : Section)

    @Delete
    suspend fun deleteSection(section : Section)
//
    @Query("SELECT DISTINCT term FROM Section")
    fun getTerms(): Flow<List<String>>

    @Query("SELECT DISTINCT subject FROM Section")
    fun getSubjects(): Flow<List<String>>

    @Query("SELECT DISTINCT section FROM Section")
    fun getModality(): Flow<List<String>>

    @Query("SELECT DISTINCT credits FROM Section")
    fun getCredits(): Flow<List<String>>

    @Query("SELECT DISTINCT instructor FROM Section")
    fun getInstructors(): Flow<List<String>>

    @Query("SELECT DISTINCT genEd FROM Section")
    fun getGenEds(): Flow<List<String>>

    @Query("SELECT DISTINCT time FROM Section")
    fun getTimes(): Flow<List<String>>

    @Query("SELECT DISTINCT days FROM Section")
    fun getDays(): Flow<List<String>>

    @Query("SELECT DISTINCT title FROM Section")
    fun getTitles(): Flow<List<String>>

    @Query("SELECT DISTINCT number FROM Section")
    fun getCourseNumbers(): Flow<List<String>>

    @Query("SELECT * FROM Section")
    fun getAllSections(): Flow<List<Section>>
}