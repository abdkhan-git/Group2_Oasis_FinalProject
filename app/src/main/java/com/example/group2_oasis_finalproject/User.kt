package com.example.group2_oasis_finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "Email")
    var Email: String = "EMAIL_EMPTY",

    @ColumnInfo(name = "First")
    var First: String = "FIRST_EMPTY",

    @ColumnInfo(name = "Last")
    var Last: String = "LAST_EMPTY",

    @ColumnInfo(name = "Pin")
    var Pin: String = "PIN_EMPTY",

    @PrimaryKey
    var RamID: String = "RAMID_EMPTY"
) {
    // Default constructor for Room or Firestore
    constructor() : this("EMAIL_EMPTY", "FIRST_EMPTY", "LAST_EMPTY", "PIN_EMPTY", "RAMID_EMPTY")
}
