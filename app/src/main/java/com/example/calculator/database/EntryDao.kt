package com.example.calculator.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface EntryDao {
    @Query("SELECT * FROM entry")
    fun getAll(): List<Entry>
//
    @Insert()
    fun insertAll(vararg entry:Entry)
//    @Delete()
//    fun delete(myEntries:Entry)
}