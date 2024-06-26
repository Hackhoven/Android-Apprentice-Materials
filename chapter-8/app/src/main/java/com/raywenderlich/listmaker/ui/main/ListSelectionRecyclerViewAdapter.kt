package com.raywenderlich.listmaker.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.listmaker.databinding.ListSelectionViewHolderBinding
import com.raywenderlich.listmaker.models.TaskList

class ListSelectionRecyclerViewAdapter(private val lists: MutableList<TaskList>) :
    RecyclerView.Adapter<ListSelectionRecyclerViewAdapter.ListSelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        val binding = ListSelectionViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListSelectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.binding.itemNumber.text = (position + 1).toString()
        holder.binding.itemString.text = lists[position].name
    }

    override fun getItemCount(): Int = lists.size

    fun listsUpdated() {
        notifyItemInserted(lists.size - 1)
    }

    class ListSelectionViewHolder(val binding: ListSelectionViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
}
