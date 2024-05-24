package com.ethan.demo.ui.activity

import android.os.Bundle
import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityStickyBinding

class ActivitySticky : ActivityBusinessBase<ActivityStickyBinding>() {

    override fun layoutResId(): Int = R.layout.activity_sticky

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityStickyBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }


}