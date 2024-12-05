package com.example.group2_oasis_finalproject.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM Course WHERE subject = :subject AND number = :number")
    fun getCourse(subject: String, number: String): Flow<Course?>

    @Query("SELECT * FROM Course WHERE credits = :credits")
    fun getCourseByCredits(credits: String): Flow<List<Course?>>

    @Query("SELECT * FROM Course WHERE title LIKE :partialTitle || '%'")
    fun getCourseByTitle(partialTitle: String): Flow<List<Course?>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCourse(course : Course)

    @Update
    suspend fun updateCourse(course : Course)

    @Delete
    suspend fun deleteCourse(course : Course)

    @Query("""
        SELECT * FROM Section
        WHERE (:crn IS NULL OR crn = :crn)
          AND (:courseSubject IS NULL OR courseSubject LIKE '%' || :courseSubject || '%')
          AND (:courseNumber IS NULL OR courseNumber LIKE '%' || :courseNumber || '%')
          AND (:section IS NULL OR section LIKE '%' || :section || '%')
          AND (:days IS NULL OR days LIKE '%' || :days || '%')
          AND (:time IS NULL OR time LIKE '%' || :time || '%')
          AND (:capacity IS NULL OR capacity LIKE '%' || :capacity || '%')
          AND (:actual IS NULL OR actual LIKE '%' || :actual || '%')
          AND (:remaining IS NULL OR remaining LIKE '%' || :remaining || '%')
          AND (:instructor IS NULL OR instructor LIKE '%' || :instructor || '%')
          AND (:date IS NULL OR date LIKE '%' || :date || '%')
          AND (:location IS NULL OR location LIKE '%' || :location || '%')
          AND (:term IS NULL OR term LIKE '%' || :term || '%')
    """)
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSection(section : Section)

    @Update
    suspend fun updateSection(section : Section)

    @Delete
    suspend fun deleteSection(section : Section)

    @Query("SELECT DISTINCT term FROM Section")
    suspend fun getTerms(): List<String>

    @Query("SELECT DISTINCT subject FROM Course")
    suspend fun getSubjects(): List<String>

    @Query("SELECT DISTINCT section FROM Section")
    suspend fun getModality(): List<String>

    @Query("SELECT DISTINCT credits FROM Course")
    suspend fun getCredits(): List<String>

    @Query("SELECT DISTINCT instructor FROM Section")
    suspend fun getInstructors(): List<String>

    @Query("SELECT DISTINCT genEd FROM Course")
    suspend fun getGenEds(): List<String>

    @Query("SELECT DISTINCT time FROM Section")
    suspend fun getTimes(): List<String>

    @Query("SELECT DISTINCT days FROM Section")
    suspend fun getDays(): List<String>
}