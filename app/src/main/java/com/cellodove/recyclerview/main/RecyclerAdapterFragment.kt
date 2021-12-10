package com.cellodove.recyclerview.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cellodove.recyclerview.databinding.FragmentRecyclerAdapterBinding

class RecyclerAdapterFragment : Fragment() {
    private lateinit var binding : FragmentRecyclerAdapterBinding
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecyclerAdapterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileDetail.setOnClickListener {}

        viewModel.profileDataInfo.observe(viewLifecycleOwner){
            var recyclerAdapter = RecyclerAdapter()
            recyclerAdapter.setData(it)

            binding.recyclerList.adapter = recyclerAdapter
            binding.profileDetail.setOnClickListener {
                viewModel.liveFragmentStep.value = MainViewModel.FragmentStep.PROFILE_DETAIL
            }

            recyclerAdapter.setOnItemClickListener(object : RecyclerAdapter.OnItemClickListener{
                override fun onItemClick(position: Int) {
                    Toast.makeText(requireContext(),"${it[position].userName} , ${it[position].userClassNumber}", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }
}