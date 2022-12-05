package com.example.ecoquests

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CurrentQuestsDAO {

    @Insert
    suspend fun insertQuest(quest: Quest)

    @Delete
    suspend fun deleteQuest(quest: Quest)

    @Query("SELECT * FROM current_quests_table")
    fun getAllQuest(): LiveData<List<Quest>>
}