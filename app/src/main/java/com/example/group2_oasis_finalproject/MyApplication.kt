package com.example.group2_oasis_finalproject

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MyApplication : Application() {

    companion object {

        lateinit var UsersRepository : UsersRepository

    }

    override fun onCreate() {
        super.onCreate()

        // Perform initialization tasks here
        //FirebaseApp.initializeApp()
        UsersRepository = UsersRepository(this.applicationContext, FirebaseFirestore.getInstance())
    }

}