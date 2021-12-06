package com.cellodove.recyclerview.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cellodove.recyclerview.databinding.RecyclerAdapterHeaderBinding
import com.cellodove.recyclerview.databinding.RecyclerAdapterItemBinding
import com.cellodove.recyclerview.repository.model.ProfileListInfo

class RecyclerAdapter(var statusDataList : ArrayList<ProfileListInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    private lateinit var onItemClickListener : OnItemClickListener

    fun setOnItemClickListener(listener : OnItemClickListener){
        this.onItemClickListener = listener
    }


    class HeaderHolder(binding: RecyclerAdapterHeaderBinding) : RecyclerView.ViewHolder(binding.root)

    inner class GatewayListViewHolder(private val binding: RecyclerAdapterItemBinding, context: Context) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        var context = context
        var onBindPosition = 0

        fun onBind(profileListInfo: ProfileListInfo, position1: Int){

            binding.userNumber.text = profileListInfo.userNumber
            binding.userDepartment.text = profileListInfo.userDepartment
            binding.userName.text = profileListInfo.userName
            binding.userClassNumber.text = profileListInfo.userClassNumber
            onBindPosition = position1
            binding.userName.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view?.id == binding.userName.id){
                onItemClickListener.onItemClick(onBindPosition-1)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var holder: RecyclerView.ViewHolder = if (viewType == TYPE_HEADER){
            HeaderHolder(RecyclerAdapterHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }else{
            GatewayListViewHolder(RecyclerAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),parent.context)
        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GatewayListViewHolder){
            var gatewayListViewHolder = holder as GatewayListViewHolder
            gatewayListViewHolder.onBind(statusDataList.get(position-1),position)
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
        return statusDataList.size + 1
    }
}