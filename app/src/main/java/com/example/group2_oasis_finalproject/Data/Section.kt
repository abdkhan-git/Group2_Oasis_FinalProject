package com.example.group2_oasis_finalproject.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "Section",
    primaryKeys = ["crn"],
)
data class Section (
    @ColumnInfo(name = "crn")
    var crn : String = "",
    @ColumnInfo(name = "subject")
    var courseSubject : String = "",
    @ColumnInfo(name = "number")
    var courseNumber : String = "",
    @ColumnInfo(name = "section")
    var section : String = "", // Modality
    @ColumnInfo(name = "days")
    var days : String = "",
    @ColumnInfo(name = "time")
    var time : String = "",
    @ColumnInfo(name = "capacity")
    var capacity : String = "",
    @ColumnInfo(name = "actual")
    var actual : String = "",
    @ColumnInfo(name = "remaining")
    var remaining : String = "",
    @ColumnInfo(name = "instructor")
    var instructor : String = "",
    @ColumnInfo(name = "date")
    var date : String = "",
    @ColumnInfo(name = "location")
    var location : String = "",
    @ColumnInfo(name = "term")
    var term : String = "",
    @ColumnInfo(name = "credits")
    var credits: String = "",
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "genEd")
    var genEd: String = ""
)