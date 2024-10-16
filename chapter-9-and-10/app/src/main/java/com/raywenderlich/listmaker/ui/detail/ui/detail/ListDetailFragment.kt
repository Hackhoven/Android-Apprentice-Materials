package com.raywenderlich.listmaker.ui.detail.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.listmaker.R
import com.raywenderlich.listmaker.databinding.ListDetailFragmentBinding

//import com.raywenderlich.listmaker.ui.detail.R

class ListDetailFragment : Fragment() {

    lateinit var binding: ListDetailFragmentBinding
    companion object {
        fun newInstance() = ListDetailFragment()
    }
    private lateinit var viewModel: ListDetailViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) { // OnCreate
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ListDetailViewModel::class.java)
        val recyclerAdapter = ListItemsRecyclerViewAdapter(viewModel.list)
        binding.listItemsRecyclerview.adapter = recyclerAdapter
        binding.listItemsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        viewModel.onTaskAdded = {
            recyclerAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ListDetailFragmentBinding.inflate(inflater,
            container, false)
        return binding.root
    }

}