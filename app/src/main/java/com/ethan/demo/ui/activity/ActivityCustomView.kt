package com.ethan.demo.ui.activity

import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityCustomViewBinding

class ActivityCustomView : ActivityBusinessBase<ActivityCustomViewBinding>() {

    override fun layoutResId(): Int= R.layout.activity_custom_view
    override fun initView() {
        super.initView()
    }
}