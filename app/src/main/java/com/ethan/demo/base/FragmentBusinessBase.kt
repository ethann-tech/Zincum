package com.ethan.demo.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.ethan.demo.util.LoadingUtil
import com.ethan.zincum.base.FragmentDataBindingBase
abstract class FragmentBusinessBase<DB : ViewDataBinding> : FragmentDataBindingBase<DB>()  {
    private lateinit var mLoadingUtil: LoadingUtil
    protected val mLogger: org.slf4j.Logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)
    override fun initView(view: View, savedInstanceState: Bundle?) {
        mLoadingUtil = LoadingUtil(mContext)
    }

    override fun showLoading(message: String) {
        mLoadingUtil.showLoading(text = message)
    }
    override fun hideLoading() {
        super.hideLoading()
        mLoadingUtil.hideLoading()
    }

}