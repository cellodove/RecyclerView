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
    private var gatewayData = arrayListOf<ProfileListInfo>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecylerAdapterBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileDetail.setOnClickListener {

        }

        //gatewayData.clear()
        gatewayData.add(ProfileListInfo("1","기계공학부","홍길동","20217724"))
        gatewayData.add(ProfileListInfo("2","컴퓨터공학부","고길동","20217724"))
        gatewayData.add(ProfileListInfo("3","전기공학부","이철수","20217724"))
        gatewayData.add(ProfileListInfo("4","전자공학부","고길순","20217724"))
        gatewayData.add(ProfileListInfo("5","화학공학부","김짱아","20217724"))
        gatewayData.add(ProfileListInfo("6","컴퓨터공학부","신짱구","20217724"))
        gatewayData.add(ProfileListInfo("7","전자공학부","이유리","20217724"))
        gatewayData.add(ProfileListInfo("8","화학공학부","이세아","20217724"))
        gatewayData.add(ProfileListInfo("9","기계공학부","박진아","20217724"))
        var recyclerAdapter = RecyclerAdapter(gatewayData)
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