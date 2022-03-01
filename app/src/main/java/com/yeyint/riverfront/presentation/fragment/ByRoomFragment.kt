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
import com.yeyint.riverfront.databinding.FragmentByRoomBinding
import com.yeyint.riverfront.presentation.adapter.ByRoomAdapter

class ByRoomFragment : Fragment() {

    private lateinit var binding : FragmentByRoomBinding
    private var adapter : ByRoomAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentByRoomBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ByRoomAdapter()
        val layoutManager =
            LinearLayoutManager(BaseApplication.getInstance(), LinearLayoutManager.VERTICAL, false)

        binding.rvByRoom.layoutManager = layoutManager
        binding.rvByRoom.addItemDecoration(SpaceItemDecoration(10,1))
        binding.rvByRoom.adapter = adapter

        adapter?.setItem(ProvideData.getByRoomList())
    }
}