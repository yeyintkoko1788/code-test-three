package com.yeyint.riverfront.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeyint.riverfront.BaseApplication
import com.yeyint.riverfront.common.SpaceItemDecoration
import com.yeyint.riverfront.data.ProvideData
import com.yeyint.riverfront.databinding.FragmentByRateBinding
import com.yeyint.riverfront.presentation.adapter.ByRateAdapter


class ByRateFragment : Fragment(){

    private lateinit var binding : FragmentByRateBinding
    private var adapter : ByRateAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentByRateBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ByRateAdapter()
        val layoutManager =
            LinearLayoutManager(BaseApplication.getInstance(), LinearLayoutManager.VERTICAL, false)
        binding.rvByRate.layoutManager = layoutManager
        binding.rvByRate.addItemDecoration(SpaceItemDecoration(10,0))
        binding.rvByRate.adapter = adapter

        adapter?.setItem(ProvideData.getByRateList())
    }
}