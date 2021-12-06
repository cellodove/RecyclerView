package com.cellodove.recyclerview.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cellodove.recyclerview.databinding.FragmentListAdapterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class ListAdapterFragment : Fragment() {
    lateinit var binding: FragmentListAdapterBinding
    private val viewModel : MainViewModel by activityViewModels()


    private val serviceJob = SupervisorJob()
    private val ioScope = CoroutineScope(Dispatchers.IO + serviceJob)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListAdapterBinding  .inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    private fun statusChange() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("onDestroyView","onDestroyView")
    }
}