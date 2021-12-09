package com.cellodove.recyclerview.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cellodove.recyclerview.R
import com.cellodove.recyclerview.repository.model.ProfileDetailInfo
import com.cellodove.recyclerview.repository.model.ProfileListInfo
import com.cellodove.recyclerview.util.SingleLiveEvent
import com.cellodove.recyclerview.util.Timer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    enum class FragmentStep { HOME, PROFILE_DETAIL }
    val liveFragmentStep = SingleLiveEvent<FragmentStep>()
    var profileDataInfo = MutableLiveData(arrayListOf<ProfileListInfo>())
    var profileDetailDataInfo = MutableLiveData(arrayListOf<ProfileDetailInfo>())

    init {
        var profileData = arrayListOf<ProfileListInfo>()
        profileData.add(ProfileListInfo("1","기계공학부","홍길동","20217724"))
        profileData.add(ProfileListInfo("2","컴퓨터공학부","고길동","20217724"))
        profileData.add(ProfileListInfo("3","전기공학부","이철수","20217724"))
        profileData.add(ProfileListInfo("4","전자공학부","고길순","20217724"))
        profileData.add(ProfileListInfo("5","화학공학부","김짱아","20217724"))
        profileData.add(ProfileListInfo("6","컴퓨터공학부","신짱구","20217724"))
        profileData.add(ProfileListInfo("7","전자공학부","이유리","20217724"))
        profileData.add(ProfileListInfo("8","화학공학부","이세아","20217724"))
        profileData.add(ProfileListInfo("9","기계공학부","박진아","20217724"))

        profileData.add(ProfileListInfo("10","국어국문학과","킹세종","20092724"))
        profileData.add(ProfileListInfo("11","경영학과","이경영","20187712"))
        profileData.add(ProfileListInfo("12","수학과","백수학","20157324"))
        profileData.add(ProfileListInfo("13","독어독문학과","최다니엘","20187414"))
        profileData.add(ProfileListInfo("14","영문학과","김힙합","20137723"))
        profileData.add(ProfileListInfo("15","영화연극학과","비둘기","20131578"))

        profileDataInfo.value = profileData

        var profileDetailData = arrayListOf<ProfileDetailInfo>()
        profileDetailData.add(ProfileDetailInfo(R.drawable.man,"홍길동","20살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.man2,"고길동","25살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.man2,"이철수","21살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman,"고길순","24살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman2,"김짱아","20살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.man,"신짱구","23살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman,"이유리","26살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman2,"이세아","22살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman,"박진아","20살"))

        profileDetailData.add(ProfileDetailInfo(R.drawable.woman,"킹세종","24살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman2,"이경영","20살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.man,"백수학","23살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman,"최다니엘","26살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman2,"김힙합","22살"))
        profileDetailData.add(ProfileDetailInfo(R.drawable.woman,"비둘기","20살"))

        profileDetailDataInfo.value = profileDetailData
    }
}