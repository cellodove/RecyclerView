package com.cellodove.recyclerview.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cellodove.recyclerview.databinding.RecyclerAdapterHeaderBinding
import com.cellodove.recyclerview.databinding.RecyclerAdapterItemBinding
import com.cellodove.recyclerview.repository.model.ProfileListInfo

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    private var data = arrayListOf<ProfileListInfo>()


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    private lateinit var onItemClickListener : OnItemClickListener

    fun setOnItemClickListener(listener : OnItemClickListener){
        this.onItemClickListener = listener
    }

    inner class HeaderHolder(binding: RecyclerAdapterHeaderBinding) : RecyclerView.ViewHolder(binding.root)
    inner class ProfileListViewHolder(private val binding: RecyclerAdapterItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        private var onBindPosition = 0

        fun onBind(profileListInfo: ProfileListInfo, position: Int){
            binding.userNumber.text = profileListInfo.userNumber
            binding.userDepartment.text = profileListInfo.userDepartment
            binding.userName.text = profileListInfo.userName
            binding.userClassNumber.text = profileListInfo.userClassNumber
            onBindPosition = position
            binding.root.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            onItemClickListener.onItemClick(onBindPosition-1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var holder: RecyclerView.ViewHolder = if (viewType == TYPE_HEADER){
            HeaderHolder(RecyclerAdapterHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }else{
            ProfileListViewHolder(RecyclerAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProfileListViewHolder){
            var gatewayListViewHolder = holder
            gatewayListViewHolder.onBind(data[position-1],position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            TYPE_HEADER
        }else{
            TYPE_ITEM
        }
    }

    override fun getItemCount(): Int {
        return data.size + 1
    }

    fun setData(data: List<ProfileListInfo>){
        this.data = data as ArrayList<ProfileListInfo>
        notifyDataSetChanged()
    }

}