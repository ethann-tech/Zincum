package com.ethan.zincum.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class FragmentDataBindingBase<DB : ViewDataBinding> : FragmentCore() {
    lateinit var mBinding: DB
    override fun getLayoutView(inflater: LayoutInflater, container: ViewGroup?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return mBinding.root
    }
}