package com.example.calculator.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Entry::class], version = 1, exportSchema = false)
abstract class EntryDB:RoomDatabase() {
    abstract fun entryDao(): EntryDao
}