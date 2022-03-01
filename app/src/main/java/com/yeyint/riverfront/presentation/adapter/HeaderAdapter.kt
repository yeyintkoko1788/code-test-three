package com.yeyint.riverfront.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyint.riverfront.BaseApplication
import com.yeyint.riverfront.data.HeaderVO
import com.yeyint.riverfront.databinding.ViewItemHeaderBinding

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var item = ArrayList<HeaderVO>()

    fun setData(item : ArrayList<HeaderVO>){
        this.item.clear()
        this.item = item

    }

    class HeaderViewHolder(private var itemBinding : ViewItemHeaderBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data : HeaderVO){
            Glide.with(BaseApplication.getInstance())
                .load(data.image)
                .into(itemBinding.ivHeader)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder(ViewItemHeaderBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size
}