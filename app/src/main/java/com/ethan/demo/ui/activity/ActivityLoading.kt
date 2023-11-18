package com.ethan.demo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBase
import com.ethan.demo.databinding.ActivityLoadingBinding
import com.ethan.zincum.dialog.IOSLoadingDialog

class ActivityLoading : ActivityBase() {
    private lateinit var mBinding: ActivityLoadingBinding

    companion object {
        fun jump(context: Context) {
            context.startActivity(Intent(context, ActivityLoading::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.includeToolbar.toolbar.title = "Loading"
        setSupportActionBar(mBinding.includeToolbar.toolbar)
        mBinding.includeToolbar.toolbar.setNavigationIcon(R.drawable.nav_back)
        mBinding.includeToolbar.toolbar.setNavigationOnClickListener { finish() }

        mBinding.btnDialogIos.setOnClickListener {
            val dialog = IOSLoadingDialog().setOnTouchOutside(true).showNow(supportFragmentManager, "IosLoadingDialog")
        }
    }
}