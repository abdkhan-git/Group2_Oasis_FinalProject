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
    fun getCourse(subject: String, number: Int): Flow<Course?>

    @Query("SELECT * FROM Course WHERE credits = :credits")
    fun getCourseByCredits(credits: Int): Flow<List<Course?>>

    @Query("SELECT * FROM Course WHERE title LIKE :partialTitle || '%'")
    fun getCourseByTitle(partialTitle: String): Flow<List<Course?>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCourse(course : Course)

    @Update
    suspend fun updateCourse(course : Course)

    @Delete
    suspend fun deleteCourse(course : Course)
}