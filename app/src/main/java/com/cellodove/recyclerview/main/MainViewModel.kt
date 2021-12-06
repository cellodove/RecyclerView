package com.cellodove.recyclerview.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cellodove.recyclerview.util.SingleLiveEvent
import com.cellodove.recyclerview.util.Timer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val baseJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + baseJob)

    enum class FragmentStep { HOME, PROFILE_DETAIL }



    private var scanTimer = Timer(30000) {  }
    val liveFragmentStep = SingleLiveEvent<FragmentStep>()

    var responseData = MutableLiveData<Int>()
    var responseComplete = MutableLiveData<Int>()
    var insertData = MutableLiveData(false)
    var liveWifiList = MutableLiveData(arrayListOf<String>())



    init {
        viewModelScope.launch {
        }
    }

}