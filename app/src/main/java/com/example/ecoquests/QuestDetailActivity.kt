package com.example.ecoquests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.ecoquests.databinding.ActivityQuestDetailBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuestDetailActivity : AppCompatActivity() {

    private lateinit var database: QuestDatabase
    private lateinit var binding: ActivityQuestDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(applicationContext, QuestDatabase::class.java, "currentQuestDB").build()

        val questId = intent.getIntExtra(QUEST_ID_EXTRA, -1)
        val quest = questFromId(questId)

        if(quest != null) {
            val duration = quest.duration.toString() + " Days"
            binding.questIcon.setImageResource(quest.icon)
            binding.name.text = quest.name
            binding.duration.text = duration
            binding.desciption.text = quest.description
            binding.questIcon.setBackgroundResource(quest.background)

            binding.btnStartChallenge.setOnClickListener{
                GlobalScope.launch {
                    database.questDao().insertQuest(quest)
                    Toast.makeText(applicationContext, "quest Added", Toast.LENGTH_LONG).show()
                    database.questDao().deleteQuest(quest)
                    Toast.makeText(applicationContext, "quest Deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun questFromId(questId: Int): Quest? {

        for(quest in questList) {
            if(quest.id == questId) {
                return quest
            }
        }
        return null
    }
}