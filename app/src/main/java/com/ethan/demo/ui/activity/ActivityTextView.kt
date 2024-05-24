package com.ethan.demo.ui.activity

import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityAlignTextBinding
import io.github.uhsk.kit.asDrawable

class ActivityTextView : ActivityBusinessBase<ActivityAlignTextBinding>() {

    override fun initView() {
        mBinding = ActivityAlignTextBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.includeToolbar.mToolbar.title = "TextView"
        setSupportActionBar(mBinding.includeToolbar.mToolbar)
        mBinding.includeToolbar.mToolbar.navigationIcon = R.drawable.nav_back.asDrawable(mContext)
    }


}