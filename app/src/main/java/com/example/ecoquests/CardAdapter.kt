package com.example.ecoquests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecoquests.databinding.CardCellBinding

class CardAdapter(
    private val quests: List<Quest>,
    private val clickListener: QuestClickListener
    )
    :RecyclerView.Adapter<CardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)

        return CardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        holder.bindQuest(quests[position])
    }

    override fun getItemCount(): Int = quests.size
}