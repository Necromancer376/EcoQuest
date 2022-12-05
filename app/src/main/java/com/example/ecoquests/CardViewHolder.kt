package com.example.ecoquests

import androidx.recyclerview.widget.RecyclerView
import com.example.ecoquests.databinding.CardCellBinding
import java.security.PrivateKey

class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: QuestClickListener
): RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindQuest(quest: Quest){
        val duration = quest.duration.toString() + " Days"
        cardCellBinding.questIcon.setImageResource(quest.icon)
        cardCellBinding.name.text = quest.name
        cardCellBinding.duration.text = duration
        cardCellBinding.questIcon.setBackgroundResource(quest.background)

        cardCellBinding.questCardView.setOnClickListener {
            clickListener.onClick(quest)
        }
    }
}