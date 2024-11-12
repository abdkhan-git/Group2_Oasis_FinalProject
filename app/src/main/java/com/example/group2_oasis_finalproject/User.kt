package com.example.group2_oasis_finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @ColumnInfo(name = "Email")
    var Email : String,
    @ColumnInfo(name = "First")
    var First: String,
    @ColumnInfo(name = "Last")
    var Last: String,
    @ColumnInfo(name = "Pin")
    var Pin : String,
    @PrimaryKey
    var RamID : String,
) {
    constructor() : this("EMAIL_EMPTY","FIRST_EMPTY","LAST_EMPTY","PIN_EMPTY","RAMID_EMPTY")
}