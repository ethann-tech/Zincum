package com.ethan.zincum.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class ActivityDataBindingBase<DB : ViewDataBinding> : ActivityCore() {
    lateinit var mBinding: DB

    override fun bindLayoutResId(layoutResId: Int) {
        super.bindLayoutResId(layoutResId)
        mBinding = DataBindingUtil.setContentView(this, layoutResId())
    }

}