package com.ethan.demo.ui.activity

import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityLoadingBinding
import com.ethan.zincum.dialog.IOSLoadingDialog

class ActivityLoading : ActivityBusinessBase<ActivityLoadingBinding>() {

    override fun layoutResId(): Int =R.layout.activity_loading
    override fun initView() {
        super.initView()
        mBinding.includeToolbar.mToolbar.title = "Loading"
        setSupportActionBar(mBinding.includeToolbar.mToolbar)
        mBinding.includeToolbar.mToolbar.setNavigationIcon(R.drawable.nav_back)
        mBinding.includeToolbar.mToolbar.setNavigationOnClickListener { finish() }

        mBinding.btnDialogIos.setOnClickListener {
            val dialog = IOSLoadingDialog().setOnTouchOutside(true).showNow(supportFragmentManager, "IosLoadingDialog")
        }
    }

}