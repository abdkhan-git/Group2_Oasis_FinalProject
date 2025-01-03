package com.example.group2_oasis_finalproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.group2_oasis_finalproject.Data.CourseDao
import com.example.group2_oasis_finalproject.Data.Schedule
import com.example.group2_oasis_finalproject.Data.Section
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [User::class, Section::class, Schedule::class],
    version = 8,
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun CourseDao(): CourseDao

    companion object {
        @Volatile
        private var Instance: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, UserDatabase::class.java, "user_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {Instance = it}
            }
        }
    }
}