package com.ethan.demo

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethan.flexibleddivider.HorizontalDividerItemDecoration
import com.ethan.demo.ui.activity.ActivityLoading
import com.ethan.demo.ui.activity.ActivityResendMsg
import com.ethan.demo.ui.activity.ActivityStepNavBar
import com.ethan.demo.ui.activity.ActivityStickyHome
import com.ethan.demo.ui.activity.ActivityTimeUtil
import com.ethan.demo.ui.activity.ActivityVerificationCode
import com.ethan.demo.adapter.MainAdapter
import com.ethan.demo.base.ActivityBase
import com.ethan.demo.bean.MainItemBean
import com.ethan.demo.databinding.ActivityMainBinding
import com.ethan.demo.ui.activity.ActivityTest
import io.github.uhsk.kit.android.dp2px

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val items = arrayOf(
        MainItemBean(text = "StepNavigateBar"),
        MainItemBean(text = "倒计时"),
        MainItemBean(text = "短信验证码输入框"),
        MainItemBean(text = "时间工具类"),
        MainItemBean(text = "吸顶效果"),
        MainItemBean(text = "Loading"),
        MainItemBean(text =  "自定义View"),
        MainItemBean(text = "TestFragment"))

    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setSupportActionBar(mBinding.includeLayoutToolbar.toolbar)
        mBinding.includeLayoutToolbar.toolbar.title = "Zincum"
        mBinding.includeLayoutToolbar.toolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(mBinding.root.context)
            addItemDecoration(
                HorizontalDividerItemDecoration.Builder(mBinding.recyclerView.context).color(Color.LTGRAY).margin(baseContext.dp2px(16), 0).size(1).build()
            )
        }

        mainAdapter.setOnItemClickListener { _, view, position ->
            when (position) {
                0 -> ActivityStepNavBar.jump(view.context)
                1 -> ActivityResendMsg.jump(view.context)
                2 -> ActivityVerificationCode.jump(view.context)
                3 -> ActivityTimeUtil.jump(view.context)
                4 -> ActivityStickyHome.jump(view.context)
                5 -> ActivityLoading.jump(view.context)
                6 -> ActivityTest.jump(view.context)
            }
        }
        mBinding.recyclerView.adapter = mainAdapter
        mainAdapter.addAll(items.toList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_device_info -> {
                ActivityBase.jump(context = this)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}