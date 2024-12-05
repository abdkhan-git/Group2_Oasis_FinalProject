package com.example.group2_oasis_finalproject.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "Schedule",
    primaryKeys = ["crn", "RamID"],
)
data class Schedule (
    @ColumnInfo(name = "crn")
    var crn : String = "",
    @ColumnInfo(name = "RamID")
    var RamID : String = "",
)