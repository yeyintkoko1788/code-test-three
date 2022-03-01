package com.yeyint.riverfront.data

import androidx.core.content.ContextCompat
import com.yeyint.riverfront.BaseApplication
import com.yeyint.riverfront.R

object ProvideData {
    fun getHeaderList() : ArrayList<HeaderVO>{
        val data = ArrayList<HeaderVO>()
        data.add(HeaderVO(ContextCompat.getDrawable(BaseApplication.getInstance(), R.drawable.furama_2)))
        data.add(HeaderVO(ContextCompat.getDrawable(BaseApplication.getInstance(), R.drawable.furama_5)))
        data.add(HeaderVO(ContextCompat.getDrawable(BaseApplication.getInstance(), R.drawable.furama_3)))

        return data
    }

    fun getByRoomList() : ArrayList<ByRoomVO>{
        val data = ArrayList<ByRoomVO>()
        data.add(ByRoomVO(ContextCompat.getDrawable(BaseApplication.getInstance(), R.drawable.furama_4),"Deluxe Twin","Twin Single Beds,Cable TV, free Wifi", "SGD 164.99"))
        data.add(ByRoomVO(ContextCompat.getDrawable(BaseApplication.getInstance(), R.drawable.furama_1),"Deluxe Single","Single Beds,Cable TV, free Wifi", "SGD 104.99"))
        return data
    }

    fun getByRateList() : ArrayList<VoucherVO>{
        val data = ArrayList<VoucherVO>()
        data.add(VoucherVO("Mobile App Special Voucher", "SGD 169.32"))
        data.add(VoucherVO("Weekend Staycation", "SGD 169.32"))
        return data
    }
}