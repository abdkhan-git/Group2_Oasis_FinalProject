package com.example.group2_oasis_finalproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE RamID = :RamID")
    fun getUser(RamID: String): Flow<User?>

    @Query("SELECT RamID FROM User WHERE RamID = :RamID")
    fun getUserID(RamID: String): String

    @Query("SELECT Pin FROM User WHERE RamID = :RamID")
    fun getUserPin(RamID: String): String

    @Query("SELECT * FROM User ORDER BY RamID COLLATE NOCASE")
    fun getUsers(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user : User)

    @Update
    fun updateSubject(user: User)

    @Delete
    fun deleteSubject(user : User)
}