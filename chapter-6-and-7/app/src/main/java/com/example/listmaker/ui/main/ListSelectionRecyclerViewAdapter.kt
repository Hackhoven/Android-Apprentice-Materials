package com.example.listmaker.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listmaker.R
import com.example.listmaker.databinding.ListSelectionViewHolderBinding

val listTitles = arrayOf("Elmir Hajizada's Shopping List", "Elmir Hajizada's Chores", "Elmir Hajizada's Android Tutorials")

class ListSelectionRecyclerViewAdapter :
    RecyclerView.Adapter<ListSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): ListSelectionViewHolder {
        // 1
        val binding = ListSelectionViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // 2
        return ListSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listTitles.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        val context = holder.itemView.context
        val itemNumber = context.getString(R.string.list_item_number, position + 1)
        val itemTitle = listTitles[position]

        holder.binding.itemNumber.text = itemNumber
        holder.binding.itemString.text = itemTitle
    }

}