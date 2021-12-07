package com.cellodove.recyclerview.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cellodove.recyclerview.repository.model.ProfileListInfo
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
    val liveFragmentStep = SingleLiveEvent<FragmentStep>()


    var gatewayData = MutableLiveData(arrayListOf<ProfileListInfo>())

    init {
        var gatewayInfo = arrayListOf<ProfileListInfo>()
        gatewayInfo.add(ProfileListInfo("1","기계공학부","홍길동","20217724"))
        gatewayInfo.add(ProfileListInfo("2","컴퓨터공학부","고길동","20217724"))
        gatewayInfo.add(ProfileListInfo("3","전기공학부","이철수","20217724"))
        gatewayInfo.add(ProfileListInfo("4","전자공학부","고길순","20217724"))
        gatewayInfo.add(ProfileListInfo("5","화학공학부","김짱아","20217724"))
        gatewayInfo.add(ProfileListInfo("6","컴퓨터공학부","신짱구","20217724"))
        gatewayInfo.add(ProfileListInfo("7","전자공학부","이유리","20217724"))
        gatewayInfo.add(ProfileListInfo("8","화학공학부","이세아","20217724"))
        gatewayInfo.add(ProfileListInfo("9","기계공학부","박진아","20217724"))
        gatewayData.value = gatewayInfo
    }
}