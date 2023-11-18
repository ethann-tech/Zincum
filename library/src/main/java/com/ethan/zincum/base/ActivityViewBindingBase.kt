package com.ethan.zincum.base

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class ActivityViewBindingBase<VB : ViewBinding>(private val inflater: (LayoutInflater) -> VB) : ActivityCore() {
    lateinit var mBinding: VB
    override fun bindLayoutView() {
        mBinding = inflater(layoutInflater)
        setContentView(mBinding.root)
    }
}