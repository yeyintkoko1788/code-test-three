package com.yeyint.riverfront.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yeyint.riverfront.presentation.fragment.ByRateFragment
import com.yeyint.riverfront.presentation.fragment.ByRoomFragment

class FragmentPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ByRoomFragment()
            1 -> ByRateFragment()
            else -> Fragment()
        }
    }
}