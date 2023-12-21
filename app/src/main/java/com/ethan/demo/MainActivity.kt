package com.ethan.demo

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethan.flexibleddivider.HorizontalDividerItemDecoration
import com.ethan.demo.adapter.MainAdapter
import com.ethan.demo.base.ActivityBase
import com.ethan.demo.bean.MainItemBean
import com.ethan.demo.databinding.ActivityMainBinding
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
        MainItemBean(text =  "ActivityTest"),
        MainItemBean(text = "ActivityExtension"))

    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setSupportActionBar(mBinding.includeLayoutToolbar.mToolbar)
        mBinding.includeLayoutToolbar.mToolbar.title = "Zincum"
        mBinding.includeLayoutToolbar.mToolbar.setTitleTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(mBinding.root.context)
            addItemDecoration(HorizontalDividerItemDecoration.Builder(mBinding.recyclerView.context).color(Color.LTGRAY).margin(baseContext.dp2px(16), 0).size(1).build())
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
                ActivityBase.jump(context = this)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}