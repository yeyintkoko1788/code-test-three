package com.yeyint.riverfront.presentation

import android.os.Bundle
import android.view.Menu
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import androidx.viewpager.widget.PagerAdapter
import com.yeyint.riverfront.R
import com.yeyint.riverfront.common.DepthPageTransformer
import com.yeyint.riverfront.common.SpaceItemDecoration
import com.yeyint.riverfront.data.ProvideData
import com.yeyint.riverfront.databinding.ActivityMainBinding
import com.yeyint.riverfront.presentation.adapter.FragmentPagerAdapter
import com.yeyint.riverfront.presentation.adapter.HeaderAdapter


class MainActivity : BaseActivity() {

    private lateinit var binding : ActivityMainBinding
    private var headerAdapter : HeaderAdapter? = null
    private lateinit var pagerAdapter : FragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpToolbar(binding.toolbar,true)
        supportActionBar?.title = ""
        headerAdapter = HeaderAdapter()
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(binding.rvHeader)
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvHeader.layoutManager = layoutManager
        binding.rvHeader.addItemDecoration(SpaceItemDecoration(10,3))
        binding.rvHeader.adapter = headerAdapter

        setHeaderData()
        initPagerAdapter()

        binding.rgTab.setOnCheckedChangeListener { _, p1 ->
            when (p1) {
                binding.rbByRoom.id -> {
                    binding.viewpager.setCurrentItem(0,true)
                }
                binding.rbRate.id -> {
                    binding.viewpager.setCurrentItem(1,true)
                }
            }
        }
    }

    private fun initPagerAdapter(){
        pagerAdapter = FragmentPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewpager.isUserInputEnabled = false
        binding.viewpager.adapter = pagerAdapter
        binding.viewpager.setPageTransformer(DepthPageTransformer())
    }
    private fun setHeaderData(){
        headerAdapter?.setData(ProvideData.getHeaderList())
        binding.rvHeader.smoothScrollToPosition(1)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}