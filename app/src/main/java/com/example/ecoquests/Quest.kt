package com.example.ecoquests

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

var questList = mutableListOf<Quest>()

val QUEST_ID_EXTRA = "quest_extra"

@Entity(tableName = "current_quests_table")
data class Quest(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "duration") var duration: Int,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "icon") var icon: Int,
    @ColumnInfo(name = "background") var background: Int,
    @PrimaryKey(autoGenerate = true) var id: Int? = questList.size
)