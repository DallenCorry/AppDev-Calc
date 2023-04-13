package com.example.calculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entry(
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(name = "formula") val formula:String,
    @ColumnInfo(name = "result") val result:Double
)
