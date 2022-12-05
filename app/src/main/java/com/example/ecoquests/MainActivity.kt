package com.example.ecoquests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecoquests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), QuestClickListener {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addQuests()

        val mainActivity = this
        binding.rvMainActivity.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = CardAdapter(questList, mainActivity)
        }
    }

    override fun onClick(quest: Quest) {
        val intent = Intent(applicationContext, QuestDetailActivity::class.java)
        intent.putExtra(QUEST_ID_EXTRA, quest.id)
        startActivity(intent)
    }

    fun addQuests(){
        var quest1 = Quest(
            "Plant 3 Trees",
            3,
            "Plant 1 tree for 3 days and take care of them properly. Preferably choose native species",
            R.drawable.leaf,
            R.color.leafGreen
        )
        questList.add(quest1)

        var quest2 = Quest(
            "Reduce Water Usage by 30%",
            7,
            "Reduce water used everyday by 30%. Identify what part of your life uses most water and reduce it. ",
            R.drawable.drop,
            R.color.waterBlue
        )
        questList.add(quest2)

        var quest3 = Quest(
            "Use 1 Bag",
            7,
            "For a week do not accept bag from shopkeepers instead carry your own bad preferably cloth bag",
            R.drawable.garbage,
            R.color.garbageRed
        )
        questList.add(quest3)

        var quest4 = Quest(
            "Walk instead of Card",
            7,
            "For a week whenever going to nearby places walk or use a bicycle instead of other vehicles",
            R.drawable.wind,
            R.color.windGrey
        )
        questList.add(quest4)

        var quest5 = Quest(
            "Make compose at home",
            30,
            "For a month separate your organic waste and create compose at home." +
                    " When the compost done add it to soil to make it more nutrient",
            R.drawable.soil,
            R.color.soilBrown
        )
        questList.add(quest5)

        var quest6 = Quest(
            "Collect trash",
            7,
            "Whenever you go for a walk, collect at least 1-2 pieces of trash and properly dispose it.",
            R.drawable.garbage,
            R.color.garbageRed
        )
        questList.add(quest6)

        var quest7 = Quest(
            "Get to know local species",
            30,
            "Go to the woods/forested area near your house get knowledge about native species." +
                    " Local species are reducing in number due to invasive species. Plant native species and look after them.",
            R.drawable.leaf,
            R.color.leafGreen
        )
        questList.add(quest7)
    }
}