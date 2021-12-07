package com.cellodove.recyclerview.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cellodove.recyclerview.databinding.FragmentRecylerAdapterBinding
import com.cellodove.recyclerview.repository.model.ProfileListInfo

class RecyclerAdapterFragment : Fragment() {

    private lateinit var binding : FragmentRecylerAdapterBinding
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecylerAdapterBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileDetail.setOnClickListener {}

        viewModel.gatewayData.observe(viewLifecycleOwner){
            var recyclerAdapter = RecyclerAdapter(it)
            binding.gatewayList.adapter = recyclerAdapter
            binding.profileDetail.setOnClickListener {
                viewModel.liveFragmentStep.value = MainViewModel.FragmentStep.PROFILE_DETAIL
            }
            recyclerAdapter.setOnItemClickListener(object : RecyclerAdapter.OnItemClickListener{
                override fun onItemClick(position: Int) {
                }
            })
        }

    }
}