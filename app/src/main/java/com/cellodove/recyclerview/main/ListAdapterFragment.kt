package com.cellodove.recyclerview.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cellodove.recyclerview.databinding.FragmentListAdapterBinding

class ListAdapterFragment : Fragment() {
    lateinit var binding: FragmentListAdapterBinding
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListAdapterBinding  .inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.profileDetailDataInfo.observe(viewLifecycleOwner){
            var listAdapter = ProfileDetailAdapter { profileDetailInfo ->
                Toast.makeText(requireContext(),"${profileDetailInfo.userName} , ${profileDetailInfo.userAge}",Toast.LENGTH_SHORT).show()
            }
            binding.profileList.adapter = listAdapter
            listAdapter.submitList(it)
        }
    }
}