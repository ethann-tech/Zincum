package com.ethan.demo.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.ethan.demo.R
import com.ethan.demo.adapter.AdapterStickyRv
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityStickHomeBinding

class ActivityStickyHome : ActivityBusinessBase<ActivityStickHomeBinding>() {
    private val mAdapter by lazy { AdapterStickyRv() }

    override fun layoutResId(): Int = R.layout.activity_stick_home


    override fun initView() {
        super.initView()
        mBinding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
        initRvData()
        mAdapter.setOnItemClickListener { adapter, view, position ->
            run {
                when (position) {
                    0 -> {
                        jump(this, ActivityStickyHome::class.java)
                    }
                }
            }
        }
    }

    private fun initRvData() {
        val list = mutableListOf<String>()
        list.add("第一种吸顶方式")
        mAdapter.addAll(list)
    }
}