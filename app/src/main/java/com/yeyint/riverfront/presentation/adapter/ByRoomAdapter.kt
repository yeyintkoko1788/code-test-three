package com.yeyint.riverfront.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyint.riverfront.BaseApplication
import com.yeyint.riverfront.data.ByRoomVO
import com.yeyint.riverfront.databinding.ViewItemByRoomBinding

class ByRoomAdapter : RecyclerView.Adapter<ByRoomAdapter.ByRoomViewHolder>(){
    private var item = ArrayList<ByRoomVO>()

    fun setItem(item : ArrayList<ByRoomVO>){
        this.item.clear()
        this.item = item
    }

    class ByRoomViewHolder(private var itemBinding : ViewItemByRoomBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data : ByRoomVO){
            Glide.with(BaseApplication.getInstance())
                .load(data.photo)
                .into(itemBinding.ivPhoto)
            itemBinding.tvName.text = data.name
            itemBinding.tvFeature.text = data.feature
            itemBinding.tvPrice.text = data.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ByRoomViewHolder {
        return ByRoomViewHolder(ViewItemByRoomBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ByRoomViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size
}