package com.example.group2_oasis_finalproject.Data

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Course", primaryKeys = ["subject", "number"])
data class Course(
    @ColumnInfo(name = "subject")
    var subject: String = "",
    @ColumnInfo(name = "number")
    var number: String = "",
    @ColumnInfo(name = "credits")
    var credits: String = "",
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "genEd")
    var genEd: String = ""
)