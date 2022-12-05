package com.example.ecoquests

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Quest::class], version = 1)
abstract class QuestDatabase: RoomDatabase() {

    abstract fun questDao(): CurrentQuestsDAO
}