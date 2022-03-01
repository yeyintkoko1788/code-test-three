package com.yeyint.riverfront.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyint.riverfront.data.VoucherVO
import com.yeyint.riverfront.databinding.ViewItemByRateBinding

class ByRateAdapter : RecyclerView.Adapter<ByRateAdapter.ByRateViewHolder>() {

    private var item = ArrayList<VoucherVO>()

    fun setItem(item : ArrayList<VoucherVO>){
        this.item.clear()
        this.item = item

    }

    class ByRateViewHolder(private var itemBinding : ViewItemByRateBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data : VoucherVO){
            itemBinding.tvVoucherName.text = data.name
            itemBinding.tvPrice.text = data.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ByRateViewHolder {
        return ByRateViewHolder(ViewItemByRateBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ByRateViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size
}