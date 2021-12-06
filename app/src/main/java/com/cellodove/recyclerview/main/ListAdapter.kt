package com.cellodove.recyclerview.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cellodove.recyclerview.databinding.ListAdapterItemBinding

class ListAdapter(var wifiData : ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    private lateinit var onItemClickListener : OnItemClickListener

    fun setOnItemClickListener(listener : OnItemClickListener){
        this.onItemClickListener = listener
    }

    inner class WifiListViewHolder(private val binding: ListAdapterItemBinding, context: Context) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        var context = context
        var onBindPosition = 0

        fun onBind(wifiData: String, position: Int){
            binding.userName.text = wifiData
            onBindPosition = position
            binding.profileImage.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view?.id == binding.profileImage.id){
                onItemClickListener.onItemClick(onBindPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WifiListViewHolder(
            ListAdapterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), parent.context
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WifiListViewHolder){
            var gatewayListViewHolder = holder as WifiListViewHolder
            gatewayListViewHolder.onBind(wifiData[position],position)
        }
    }
    override fun getItemCount(): Int {
        return wifiData.size
    }


}