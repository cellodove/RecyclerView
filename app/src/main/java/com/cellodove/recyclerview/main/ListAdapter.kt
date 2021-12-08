package com.cellodove.recyclerview.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cellodove.recyclerview.databinding.ListAdapterItemBinding
import com.cellodove.recyclerview.repository.model.ProfileDetailInfo

class ProfileDetailAdapter() : ListAdapter<ProfileDetailInfo, ProfileDetailAdapter.ProfileDataViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileDataViewHolder {
        val binding = ListAdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileDataViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ProfileDataViewHolder(private val binding: ListAdapterItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(profileData: ProfileDetailInfo){
            binding.userName.text = profileData.userName
            binding.userAge.text = profileData.userAge
        }

    }

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<ProfileDetailInfo>(){
            override fun areItemsTheSame(oldItem: ProfileDetailInfo, newItem: ProfileDetailInfo) = oldItem == newItem
            override fun areContentsTheSame(oldItem: ProfileDetailInfo, newItem: ProfileDetailInfo) = oldItem == newItem
        }
    }


}