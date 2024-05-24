package com.ethan.demo.ui.activity

import com.ethan.demo.R
import com.ethan.demo.base.ActivityBusinessBase
import com.ethan.demo.databinding.ActivityContextExtBinding
import io.github.uhsk.kit.android.readAssetFile
import io.github.uhsk.kit.asDrawable

class ActivityContextExt : ActivityBusinessBase<ActivityContextExtBinding>() {


    override fun layoutResId(): Int =R.layout.activity_context_ext

    override fun initView() {
        super.initView()
        mBinding.toolbar.title = "Context扩展"
        setSupportActionBar(mBinding.toolbar)
        mBinding.toolbar.navigationIcon = R.drawable.nav_back.asDrawable(mContext)

        val assetsFile = baseContext.readAssetFile(path = "test/result.json")
        mLogger.debug("LOG:ActivityContextExt:onCreate: assetsFile={}", assetsFile)
    }
    override fun initListener() {

    }
}