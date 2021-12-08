package com.cellodove.recyclerview.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cellodove.recyclerview.databinding.ListAdapterItemBinding

class ProfileDetailAdapter() : ListAdapter<ArrayList<String>, ProfileDetailAdapter.ProfileDataViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileDataViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProfileDataViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ProfileDataViewHolder(private val binding: ListAdapterItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        var onBindPosition = 0

        fun onBind(profileData: String, position: Int){
            binding.userName.text = profileData
            onBindPosition = position
            binding.profileImage.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
        }
    }

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<ArrayList<String>>(){
            override fun areItemsTheSame(oldItem: ArrayList<String>, newItem: ArrayList<String>) = oldItem == newItem
            override fun areContentsTheSame(oldItem: ArrayList<String>, newItem: ArrayList<String>) = oldItem == newItem
        }
    }


}