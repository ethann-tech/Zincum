package com.ethan.demo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethan.demo.adapter.AdapterStickyRv
import com.ethan.demo.databinding.ActivityStickHomeBinding

class ActivityStickyHome : AppCompatActivity() {
    private lateinit var mBinding: ActivityStickHomeBinding
    private val mAdapter by lazy {
        AdapterStickyRv()
    }

    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityStickyHome::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityStickHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
        initRvData()

        mAdapter.setOnItemClickListener { adapter, view, position -> run {
                when (position) {
                    0 -> {
                        ActivitySticky.jump(this)
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