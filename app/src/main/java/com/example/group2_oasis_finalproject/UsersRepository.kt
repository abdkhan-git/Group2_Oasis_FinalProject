package com.example.group2_oasis_finalproject

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UsersRepository (context: Context, var firestoreDb : FirebaseFirestore) {

    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) { super.onCreate(db) }
        }
//    private val database: UserDatabase = Room.databaseBuilder(context, UserDatabase::class.java, "study.db").addCallback(databaseCallback).build()
    private val database: UserDatabase = UserDatabase.getDatabase(context)

    private val userDao = database.userDao()

    fun getUser(RamID : String) = userDao.getUser(RamID)

    fun getUsers() = userDao.getUsers()

    fun getUserRamID(RamID: String) = userDao.getUserID(RamID)

    fun getUserPin(RamID: String) = userDao.getUserPin(RamID)

    fun addUser(user: User) { if (user.RamID.trim() != "") { user.RamID = userDao.addUser(user).toString() } }

    fun deleteSubject(user: User) { userDao.deleteSubject(user) }

    fun getAllUsers() : Flow<List<User>> {
        val queryFlow : Flow<List<User>> = firestoreDb.collection("OasisUsers").dataObjects<User>()
        return queryFlow
    }

    fun addUserFB(user : User) {
        firestoreDb.collection("OasisUsers").add(user)
    }

}