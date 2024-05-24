package com.ethan.demo

import android.graphics.Color
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethan.demo.adapter.MainAdapter
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.bean.MainItemBean
import com.ethan.demo.databinding.ActivityMainBinding
import com.ethan.demo.ui.activity.ActivityStepNavBar
import com.ethan.flexibleddivider.HorizontalDividerItemDecoration
import io.github.uhsk.kit.android.dp2px
import io.github.uhsk.kit.asStringResId

class MainActivity : ActivityBusinessBase<ActivityMainBinding>() {
    private val items = arrayOf(
        MainItemBean(text = "StepNavigateBar"),
        MainItemBean(text = "倒计时"),
        MainItemBean(text = "短信验证码输入框"),
        MainItemBean(text = "时间工具类"),
        MainItemBean(text = "吸顶效果"),
        MainItemBean(text = "Loading"),
        MainItemBean(text = "ActivityTest"),
        MainItemBean(text = "ActivityExtension"),
        MainItemBean(text = "Context扩展"),
        MainItemBean(text = "组件")
    )

    private val mainAdapter by lazy { MainAdapter() }

    override fun initView() {
        super.initView()
        mBinding.includeLayoutToolbar.mToolbar.title = R.string.app_name.asStringResId(context = baseContext)
        mBinding.includeLayoutToolbar.mToolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        setSupportActionBar(mBinding.includeLayoutToolbar.mToolbar)
        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(mBinding.root.context)
            addItemDecoration(HorizontalDividerItemDecoration.Builder(mBinding.recyclerView.context)
                .color(Color.LTGRAY)
                .margin(16.dp2px(), 0).size(1).build())
        }
        mBinding.recyclerView.adapter = mainAdapter
        mainAdapter.submitList(items.toList())
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_device_info -> {
               jump(context = this,ActivityStepNavBar::class.java)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}