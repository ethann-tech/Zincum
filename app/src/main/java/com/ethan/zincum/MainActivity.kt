package com.ethan.zincum

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethan.flexibleddivider.HorizontalDividerItemDecoration
import com.ethan.zincum.activity.ActivityVerificationCode
import com.ethan.zincum.adapter.MainAdapter
import com.ethan.zincum.databinding.ActivityMainBinding
import io.github.uhsk.kit.dp2px

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val items = arrayOf("StepNavigateBar", "倒计时", "短信验证码输入框")
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
                HorizontalDividerItemDecoration.Builder(mBinding.recyclerView.context)
                    .color(Color.LTGRAY)
                    .margin(baseContext.dp2px(16), 0)
                    .size(1)
                    .build()
            )
        }
        mainAdapter.setOnItemClickListener { _, view, position ->
            when (position) {
                0 -> ActivityStepNavBar.jump(view.context)
                1 -> ActivityResendMsg.jump(view.context)
                2 -> ActivityVerificationCode.jump(view.context)
            }
        }
        mBinding.recyclerView.adapter = mainAdapter
        mainAdapter.addAll(items.toList())
    }
}